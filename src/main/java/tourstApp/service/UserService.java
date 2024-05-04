package tourstApp.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tourstApp.dto.DestinationDTO;
import tourstApp.dto.ExcursionTypeDTO;
import tourstApp.dto.UserDTO;
import tourstApp.model.Destination;
import tourstApp.model.ExcursionType;
import tourstApp.model.ExcursionTypeClass;
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
        UserDTO userDTO = new UserDTO(user);

        List<Destination> destinations = userRepository.findDestinationsByUserId(user.getId());

        destinations.forEach(destination -> {
            userDTO.getDestinations().add(destination.getDestinationName());
        });


        List<ExcursionTypeClass> excursionTypesDTO = userRepository.findExcursionTypesByUserId(user.getId());
            excursionTypesDTO.forEach(excursionTypeClass -> {
                ExcursionType excursionType = excursionTypeClass.getExcursionType();
                // Add the ordinal value of the ExcursionType enum to userDTO.getExcursionTypes()
                userDTO.getExcursionTypes().add(excursionType);
        });

        return userDTO;
    }

    public User findUserById(Long id){
        User user = userRepository.findUserById(id);
        return user;
    }


}
