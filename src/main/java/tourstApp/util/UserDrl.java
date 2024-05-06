package tourstApp.util;

import lombok.Data;
import tourstApp.converter.ListToStringConverter;
import tourstApp.converter.ListToStringJsonConverter;
import tourstApp.model.Role;
import tourstApp.model.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.beust.jcommander.internal.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class UserDrl {

    private Long id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private boolean isNew;

    private Role role;


    public UserDrl() {
    }

    public UserDrl(Long id, String email, String password, String firstName, String lastName, boolean isNew) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isNew = isNew;
    }

    public UserDrl(User user){
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.isNew = user.getIsNew();        
    }


    public String getUsername() {
        return this.email;
    }

    public boolean getIsNew() {
        return this.isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }


}
