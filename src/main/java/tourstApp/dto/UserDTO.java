package tourstApp.dto;

import java.util.ArrayList;
import java.util.List;


import lombok.Data;
import tourstApp.model.Destination;
import tourstApp.model.ExcursionType;
import tourstApp.model.ExcursionTypeClass;
import tourstApp.model.User;

@Data
public class UserDTO {

    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String role;
    private List<String> destinations;
    private List<ExcursionType> excursionTypes;

    public UserDTO(User user) {
        this(user.getId(), user.getEmail(), user.getPassword(), user.getFirstName(),user.getLastName(), user.getRole().getName());
    }

    public UserDTO(Long id, String email, String password, String firstName, String lastName, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.destinations = new ArrayList<>();
        this.excursionTypes = new ArrayList<>();
    }
}
