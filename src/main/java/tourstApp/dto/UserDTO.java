package tourstApp.dto;

import lombok.Data;
import tourstApp.model.User;

@Data
public class UserDTO {

    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String role;

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
    }
}