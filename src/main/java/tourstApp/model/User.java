    package tourstApp.model;

    import lombok.Data;
    import lombok.Getter;
    import lombok.Setter;
    import tourstApp.converter.ListToStringConverter;
import tourstApp.converter.ListToStringJsonConverter;

import org.springframework.security.core.GrantedAuthority;
    import org.springframework.security.core.userdetails.UserDetails;

import com.beust.jcommander.internal.Nullable;

import javax.persistence.*;
    import java.util.ArrayList;
    import java.util.Collection;
    import java.util.List;

    @Entity
    @Getter
    @Setter
    @Table(name = "app_user")
    public class User implements UserDetails {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "email", nullable = false)
        private String email;

        @Column(name = "password", nullable = false)
        private String password;

        @Column(name = "firstName", nullable = false)
        private String firstName;

        @Column(name = "lastName", nullable = false)
        private String lastName;

        @Column(name = "new", nullable = false)
        @Nullable
        private boolean isNew;

        @OneToOne(fetch = FetchType.EAGER)
        private Role role;

        @ManyToMany
        @JoinTable(
                name = "user_destinations",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "destination_id")
        )
        private List<Destination> destinations;

        @ManyToMany
        @JoinTable(
                name = "user_excursion_types",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "excursion_type_id"
                )
        )
        private List<ExcursionTypeClass> excursionTypes;

        @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = javax.persistence.CascadeType.ALL)
        private List<Rating> ratings;

        public User() {
        }

        public User(Long id, String email, String password, String firstName, String lastName) {
            this.id = id;
            this.email = email;
            this.password = password;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(this.role);
            return authorities;
        }

        @Override
        public String getUsername() {
            return this.email;
        }

        public boolean getIsNew() {
            return this.isNew;
        }

        public void setIsNew(boolean isNew) {
            this.isNew = isNew;
        }

        public List<Destination> getDestinations() {
            return this.destinations;
        }

        public List<ExcursionTypeClass> getExcursionTypes() {
            return this.excursionTypes;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        public void setNew(boolean isNew) {
            this.isNew = isNew;
        }




    }
