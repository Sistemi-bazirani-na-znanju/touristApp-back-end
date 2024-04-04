package tourstApp.dto;

import lombok.Data;
import tourstApp.model.User;

@Data
public class UserDTO {

    private Long id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String role;

    public UserDTO(User user) {
        this(user.getId(), user.getEmail(), user.getPassword(), user.getName(),user.getSurname(), user.getRole().getName());
    }

    public UserDTO(Long id, String email, String password, String name, String surname, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }
}
