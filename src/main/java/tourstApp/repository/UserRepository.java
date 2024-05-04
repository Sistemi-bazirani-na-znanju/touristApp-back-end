package tourstApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tourstApp.model.Destination;
import tourstApp.model.ExcursionTypeClass;
import tourstApp.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserByEmail(String email);
    User findUserById(Long id);

    @Query("SELECT d FROM User u JOIN u.destinations d WHERE u.id = :userId")
    List<Destination> findDestinationsByUserId(@Param("userId") Long userId);
    
    @Query("SELECT e FROM User u JOIN u.excursionTypes e WHERE u.id = :userId")
    List<ExcursionTypeClass> findExcursionTypesByUserId(@Param("userId") Long userId);
}
