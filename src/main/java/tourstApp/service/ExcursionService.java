package tourstApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tourstApp.model.Excursion;
import tourstApp.repository.ExcursionRepository;



@Service
public class ExcursionService {
    
    @Autowired
    private ExcursionRepository excursionRepository;

    public Excursion findById(Integer id){
        return excursionRepository.findById(id).orElse(null);
    }

    public List<Excursion> findAll(){
        return excursionRepository.findAll();
    }

    public Excursion save(Excursion excursion) {
        return excursionRepository.save(excursion);
    }

    public Excursion update(Excursion excursion) {
        return excursionRepository.save(excursion);
    }
    
}
