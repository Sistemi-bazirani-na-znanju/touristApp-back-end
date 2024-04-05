package tourstApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tourstApp.model.Rating;
import tourstApp.repository.RatingRepository;



@Service
public class RatingService {
    
    @Autowired
    private RatingRepository ratingRepository;

    public Rating findById(Integer id){
        return ratingRepository.findById(id).orElse(null);
    }

    public List<Rating> findAll(){
        return ratingRepository.findAll();
    }

    public Rating save(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating update(Rating rating) {
        return ratingRepository.save(rating);
    }
    
}
