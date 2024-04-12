package tourstApp.service;

import lombok.RequiredArgsConstructor;
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
import tourstApp.model.Role;
import tourstApp.model.User;
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

    public User register(UserDTO request) {


        Role role = roleService.findByName("ROLE_USER");

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setRole(role);
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
