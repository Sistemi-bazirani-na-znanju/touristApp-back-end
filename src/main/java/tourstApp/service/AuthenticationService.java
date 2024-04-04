package tourstApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tourstApp.dto.UserDTO;
import tourstApp.model.Role;
import tourstApp.model.User;
import tourstApp.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;

    public User register(UserDTO request) {


        Role role = roleService.findByName("ROLE_USER");

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setRole(role);
        return repository.save(user);

    }


}
