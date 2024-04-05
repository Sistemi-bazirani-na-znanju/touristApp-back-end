package tourstApp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import tourstApp.model.Reservation;
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    
}
