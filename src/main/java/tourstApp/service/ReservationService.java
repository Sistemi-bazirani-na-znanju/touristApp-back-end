package tourstApp.service;

import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
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

   // private KieContainer kieContainer;

    public Reservation findById(Integer id){
        return reservationRepository.findById(id).orElse(null);
    }

    public List<Reservation> findAll(){

        List<Reservation> reservations = reservationRepository.findAll();
        for (Reservation reservation : reservations) {
            List<Excursion> excursions = reservationRepository.findExcursionsByReservationId(reservation.getId());
            reservation.setChosenExcursions(excursions);
        }
        return reservations;

    }

    public Reservation save(Reservation reservation) {
        applyDiscountRule(reservation);
        return reservationRepository.save(reservation);
    }

    public Reservation update(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    private void applyDiscountRule(Reservation reservation) {
        KieServices ks = KieServices.Factory.get();
		KieContainer kieContainer = ks.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("ksession-rules");
        kieSession.addEventListener(new DebugAgendaEventListener());
        try {
            kieSession.insert(reservation);
            kieSession.fireAllRules();
        } finally {
       //     kieSession.dispose(); 
        }
    }
    // public void setKieContainer(KieContainer kieContainer) {
    //     this.kieContainer = kieContainer;
    // }
}
