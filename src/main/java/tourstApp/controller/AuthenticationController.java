package tourstApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import tourstApp.dto.AuthenticationRequest;
import tourstApp.dto.UserDTO;
import tourstApp.dto.AuthenticationResponse;
import tourstApp.exeption.ResourceConflictException;
import tourstApp.model.User;
import tourstApp.service.AuthenticationService;
import tourstApp.service.UserService;
import tourstApp.util.TokenUtils;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final AuthenticationManager authenticationManager;
    private final TokenUtils tokenUtils;

    @Autowired
    UserService userService;


    @PostMapping(value = "/register", consumes = "application/json")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserDTO request) {
        User existingUser = userService.findByEmail(request.getEmail());

        if (existingUser != null) {
            throw new ResourceConflictException(request.getId(), "Username already exists");
        }

        User registeredUser = authenticationService.register(request);

        if (registeredUser != null) {
            return ResponseEntity.ok(
                    authenticationService.authenticate(
                            new AuthenticationRequest(request.getEmail(), request.getPassword())
                    )
            );
        } else {
            throw new ResourceConflictException(request.getId(), "Authentication faild");
        }

    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Helloooasdas");
    }


}
