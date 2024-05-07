package tourstApp.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tourstApp.model.Excursion;
import tourstApp.model.Reservation;
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query("SELECT r.chosenExcursions FROM Reservation r WHERE r.id = :reservationId")
    List<Excursion> findExcursionsByReservationId(@Param("reservationId") Integer reservationId);


    
}
