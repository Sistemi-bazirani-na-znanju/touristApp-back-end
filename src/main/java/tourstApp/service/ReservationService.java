package tourstApp.service;

import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tourstApp.model.*;
import tourstApp.repository.ReservationRepository;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    private KieContainer kieContainer;

    public Reservation findById(Integer id){
        return reservationRepository.findById(id).orElse(null);
    }

    public List<Reservation> findAll(){
        return reservationRepository.findAll();
    }

    public Reservation save(Reservation reservation) {
        applyDiscountRule(reservation);
        return reservationRepository.save(reservation);
    }

    public Reservation update(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    private void applyDiscountRule(Reservation reservation) {
        
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(reservation);
        kieSession.fireAllRules();
        kieSession.dispose();

    }
    public void setKieContainer(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }
}
