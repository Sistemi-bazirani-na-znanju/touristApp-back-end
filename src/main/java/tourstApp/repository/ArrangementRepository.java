package tourstApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tourstApp.model.Arrangement;
import tourstApp.model.Excursion;
import tourstApp.model.Rating;

public interface ArrangementRepository extends JpaRepository<Arrangement, Integer>{
    
    @Query("SELECT ex FROM Excursion ex WHERE ex.arrangement.id = :arrangementId")
    List<Excursion> findExcursionsByArrangementId(@Param("arrangementId") Integer arrangementId);

    @Query("SELECT r FROM Rating r WHERE r.arrangement.id = :arrangementId")
    List<Rating> findRatingsByArrangementId(@Param("arrangementId") Integer arrangementId);

    @Query("SELECT a FROM Arrangement a LEFT JOIN FETCH a.excursions WHERE a.id = :arrangementId")
    Arrangement findArrangementWithExcursions(@Param("arrangementId") Integer arrangementId);
    
    @Query("SELECT a FROM Arrangement a LEFT JOIN FETCH a.ratings WHERE a.id = :arrangementId")
    Arrangement findArrangementWithRatings(@Param("arrangementId") Integer arrangementId);
    
    @Query("SELECT a FROM Arrangement a LEFT JOIN FETCH a.ratings WHERE a.id = :id")
    Arrangement findByIdWithRatings(@Param("id") Integer id);

    @Query("SELECT r FROM Rating r")
    List<Rating> findAllRatings();

    @Query("SELECT DISTINCT a FROM Arrangement a LEFT JOIN FETCH a.excursions LEFT JOIN FETCH a.destination")
    List<Arrangement> findAllWithExcursionsAndDestinations();
}
