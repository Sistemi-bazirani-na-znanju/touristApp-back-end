package tourstApp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tourstApp.model.Arrangement;
import tourstApp.model.Excursion;
import tourstApp.model.Rating;
import tourstApp.model.User;
import tourstApp.repository.ArrangementRepository;
import tourstApp.repository.UserRepository;



@Service
public class ArrangementAuthService {
    
    @Autowired
    private ArrangementRepository arrangementRepository;

    @Autowired
    private UserRepository userRepository;

    public Arrangement findById(Integer id){
        return arrangementRepository.findById(id).orElse(null);
    }

    public List<Arrangement> getAll(Integer userId) {



        // KieServices ks = KieServices.Factory.get();
        // KieContainer kieContainer = ks.getKieClasspathContainer();
        // KieSession kieSession = kieContainer.newKieSession("authSession");
        // kieSession.addEventListener(new DebugAgendaEventListener());

        // List<Arrangement> arrangements = arrangementRepository.findAll();

        // User user = userRepository.findById(userId).orElse(null);

        // kieSession.insert(user);

        // kieSession.fireAllRules(ruleName -> ruleName.equals("Check if User is New or Not") || ruleName.equals("Check if User is New"));



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

    public Arrangement findByIdWithRatings(Integer id) {
        return arrangementRepository.findByIdWithRatings(id);
    }

    public List<Arrangement> findPoorlyRated(List<Arrangement> recommendedArrangements) {
        return recommendedArrangements.stream()
                                      .filter(arrangement -> arrangement.getAverageRating() > 2.5)
                                      .collect(Collectors.toList());
    }
}
