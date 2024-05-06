package tourstApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tourstApp.model.*;
import tourstApp.repository.ArrangementRepository;
import tourstApp.repository.ReservationRepository;
import tourstApp.repository.UserRepository;
import tourstApp.util.RatingDrl;
import tourstApp.util.UserDrl;



@Service
public class ArrangementService {
    
    @Autowired
    private ArrangementRepository arrangementRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public Arrangement findById(Integer id){
        return arrangementRepository.findById(id).orElse(null);
    }


    public List<Arrangement> findAll(Integer userID){

        //Long userId = (long) 1;

        Long userId = (long) userID;

        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();

        if(userId == 0){

            KieSession kieSession = kieContainer.newKieSession("unauthSession");
            kieSession.addEventListener(new DebugAgendaEventListener());

            List<Arrangement> arrangementsList = arrangementRepository.findAll();
            for (Arrangement arr : arrangementsList) {
                System.out.println("POSLAO U SESIJU");
                kieSession.insert(arr);
            }

            kieSession.fireAllRules();
            kieSession.dispose();

            kieSession = kieContainer.newKieSession("unauthSession2");
            for (Arrangement arr : arrangementsList) {
                System.out.println("POSLAO U SESIJU");
                kieSession.insert(arr);
            }

            kieSession.fireAllRules();
            kieSession.dispose();
            for (Arrangement arr : arrangementsList) {
                arrangementRepository.save(arr);
            }
            return arrangementsList;

        }
        else{

            KieSession kieSession = kieContainer.newKieSession("authSession1");
            kieSession.addEventListener(new DebugAgendaEventListener());

            List<Arrangement> arrangements = arrangementRepository.findAll();

            List<Rating> userRatings = userRepository.findRatingsByUserId(userId);

            User user = userRepository.findUserById(userId);

            List<User> users = userRepository.findAll();
            List<UserDrl> userDrls = new ArrayList();
            for (User u : users){
                userDrls.add(new UserDrl(u));
            }

            UserDrl userDrl = new UserDrl(user);

            kieSession.insert(userDrl);

            for (Rating rating : userRatings) {
                System.out.println("SENT IN SESSION");
                kieSession.insert(rating);
            }


            kieSession.fireAllRules();



            if(!userDrl.getIsNew()){
                System.out.println("User is old");

                kieSession.dispose();
                kieSession = kieContainer.newKieSession("authSession2");

                List<Reservation> reservations = reservationRepository.findAll();

                List<Rating> ratings = userRepository.findRatingsByUserId(userId);
                List<RatingDrl> ratingDrls = new ArrayList();
                for (Rating r : ratings){
                    ratingDrls.add(new RatingDrl(r));
                }

                kieSession.insert(userId);
                kieSession.insert(userDrl);

                // for (UserDrl uDrl : userDrls){
                //     System.out.println("SENT IN SESSION USERDRLS");
                //     kieSession.insert(uDrl);
                // }
                for (RatingDrl rDrl : ratingDrls){
                    System.out.println("SENT IN SESSION RATINGDRLS");
                    kieSession.insert(rDrl);
                }


                for (Arrangement arr : arrangements) {
                    System.out.println("SENT IN SESSION ARRANGEMENTS");
                    kieSession.insert(arr);
                }

                for(Reservation res : reservations){
                    System.out.println("SENT IN SESSION RESERVATIONS");
                    kieSession.insert(res);
                }


                kieSession.fireAllRules();
                kieSession.dispose();

                for (Arrangement arr : arrangements) {
                    if(arr.isRecommended()){
                        System.out.println("RECOMMENDED: " + arr.getName());
                    }
                }

                arrangements = findRecommended(arrangements);
                return arrangements;
            }
            else{



                user.setDestinations(userRepository.findDestinationsByUserId(user.getId()));
                user.setExcursionTypes(userRepository.findExcursionTypesByUserId(user.getId()));

                if(user.getDestinations().isEmpty() || user.getExcursionTypes().isEmpty()){
                    kieSession.dispose();
                    kieSession = kieContainer.newKieSession("unauthSession");
                    kieSession.addEventListener(new DebugAgendaEventListener());

                    List<Arrangement> arrangementsList = arrangementRepository.findAll();
                    for (Arrangement arr : arrangementsList) {
                        System.out.println("POSLAO U SESIJU");
                        kieSession.insert(arr);
                    }

                    kieSession.fireAllRules();
                    kieSession.dispose();

                    kieSession = kieContainer.newKieSession("unauthSession2");
                    for (Arrangement arr : arrangementsList) {
                        System.out.println("POSLAO U SESIJU");
                        kieSession.insert(arr);
                    }

                    kieSession.fireAllRules();
                    kieSession.dispose();
                    for (Arrangement arr : arrangementsList) {
                        arrangementRepository.save(arr);
                    }
                    return arrangementsList;
                }
                else{
                    System.out.println("Nije prazno");
                    return arrangementRepository.findAll();
                }


            }









        }

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

    public List<Arrangement> findRecommended(List<Arrangement> arrangements) {
        return arrangements.stream()
                           .filter(arrangement -> arrangement.isRecommended())
                           .collect(Collectors.toList());
    }
}
