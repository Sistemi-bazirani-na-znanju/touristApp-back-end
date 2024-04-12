package tourstApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tourstApp.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
    Role getRoleById(long id);
}
