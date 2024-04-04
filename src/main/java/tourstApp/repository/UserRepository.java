package tourstApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tourstApp.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserByEmail(String email);

}
