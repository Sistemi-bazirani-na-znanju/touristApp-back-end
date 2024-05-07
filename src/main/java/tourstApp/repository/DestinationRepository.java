package tourstApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tourstApp.model.Destination;

public interface DestinationRepository extends JpaRepository<Destination, Integer> {

    @Query("SELECT d FROM Destination d WHERE d.destinationName = :destinationName")
    Destination findByDestinationName(@Param("destinationName") String destinationName);
}
