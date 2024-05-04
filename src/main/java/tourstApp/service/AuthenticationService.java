package tourstApp.service;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tourstApp.dto.AuthenticationRequest;
import tourstApp.dto.AuthenticationResponse;
import tourstApp.dto.UserDTO;
import tourstApp.model.Destination;
import tourstApp.model.ExcursionTypeClass;
import tourstApp.model.Role;
import tourstApp.model.User;
import tourstApp.repository.DestinationRepository;
import tourstApp.repository.ExcursionTypeRepository;
import tourstApp.repository.UserRepository;
import tourstApp.util.TokenUtils;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenUtils tokenUtils;

    @Autowired
    private RoleService roleService;

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private ExcursionTypeRepository excursionTypeRepository;

    public User register(UserDTO request) {

        // Find the role with name "ROLE_USER"
        Role role = roleService.findByName("ROLE_USER");
    
        // Create a new User object
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setRole(role);
    
        // Initialize a list to store Destination objects
        List<Destination> destinations = new ArrayList<>();
    
        // Loop through each destination name provided in the request
        request.getDestinations().forEach(destinationName -> {
            // Find the Destination object by its name
            Destination destination = destinationRepository.findByDestinationName(destinationName);
            
            // Check if the destination exists and add it to the list
            if (destination != null) {
                destinations.add(destination);
            }
        });
    
        List<ExcursionTypeClass> excursionTypes = new ArrayList<>();

        request.getExcursionTypes().forEach(excursionType -> {
            ExcursionTypeClass excursionTypeClass = excursionTypeRepository.findByExcursionType(excursionType);

            excursionTypes.add(excursionTypeClass);
        });


        // Set the list of destinations to the User object
        user.setDestinations(destinations);

        user.setExcursionTypes(excursionTypes);
    
        // Save the User object to the repository
        return repository.save(user);
    }
    

    public AuthenticationResponse authenticate(AuthenticationRequest request){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()

        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = (User) authentication.getPrincipal();
        String jwt  = tokenUtils.generateToken(user);
        int expiresIn = tokenUtils.getExpiredIn();
        return new AuthenticationResponse(jwt,expiresIn);
    }


}
