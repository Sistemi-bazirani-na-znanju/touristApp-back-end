package tourstApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tourstApp.dto.UserDTO;
import tourstApp.model.User;
import tourstApp.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findByEmail(String email) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(email);
    }

    public UserDTO findById(Long id){
        User user = userRepository.findUserById(id);
        return new UserDTO(user);
    }

    public User findUserById(Long id){
        User user = userRepository.findUserById(id);
        return user;
    }


}
