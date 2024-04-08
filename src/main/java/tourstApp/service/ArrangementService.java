package tourstApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tourstApp.model.Arrangement;
import tourstApp.model.Excursion;
import tourstApp.model.Rating;
import tourstApp.repository.ArrangementRepository;



@Service
public class ArrangementService {
    
    @Autowired
    private ArrangementRepository arrangementRepository;

    public Arrangement findById(Integer id){
        return arrangementRepository.findById(id).orElse(null);
    }

    public List<Arrangement> findAll(){
        return arrangementRepository.findAll();
    }

    public Arrangement save(Arrangement arrangement) {
        return arrangementRepository.save(arrangement);
    }

    public Arrangement arrangementDetails(Integer arrangementId) {
        Arrangement arrangement = arrangementRepository.findArrangementWithExcursions(arrangementId);
        Arrangement arrangementWithRatings = arrangementRepository.findArrangementWithRatings(arrangementId);

        arrangement.setRatings(arrangementWithRatings.getRatings());

        return arrangement;

    }

    public Arrangement update(Arrangement arrangement) {
        return arrangementRepository.save(arrangement);
    }

    public List<Excursion> getExcursionsByArrangementId(Integer arrangementId){
        return arrangementRepository.findExcursionsByArrangementId(arrangementId);
    }

    public List<Rating> getRatingsByArrangementId(Integer arrangementId){
        return arrangementRepository.findRatingsByArrangementId(arrangementId);
    }
    
}
