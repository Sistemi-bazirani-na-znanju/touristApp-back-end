package tourstApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tourstApp.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer>{
    
}
