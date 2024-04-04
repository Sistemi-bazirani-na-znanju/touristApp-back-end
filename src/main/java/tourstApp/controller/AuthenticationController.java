package tourstApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import tourstApp.dto.AutenticationRequest;
import tourstApp.dto.UserDTO;
import tourstApp.dto.UserTokenState;
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


    @PostMapping(value ="/register", consumes = "application/json")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO request){
        User existingUser = userService.findByEmail(request.getEmail());

        if(existingUser != null){
            throw new ResourceConflictException(request.getId(), "Username already exists");
        }

        return ResponseEntity.ok(new UserDTO(authenticationService.register(request)));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<UserTokenState> authenticate(@RequestBody AutenticationRequest request){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()

        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = (User) authentication.getPrincipal();
        String jwt  = tokenUtils.generateToken(user.getUsername());
        int expiresIn = tokenUtils.getExpiredIn();
        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
    }

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Helloooasdas");
    }


}
