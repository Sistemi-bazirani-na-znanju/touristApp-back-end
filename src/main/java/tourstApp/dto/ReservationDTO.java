package tourstApp.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tourstApp.model.Arrangement;
import tourstApp.model.Excursion;
import tourstApp.model.Reservation;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {

    private Integer id;

    private int numberOfPeople;

    private double totalPrice;

    private Integer arrangementId;

    private String arrangementName;

    private List<ExcursionDTO> chosenExcursions;

    public ReservationDTO(Reservation reservation) {
        this.id = reservation.getId();

        this.numberOfPeople = reservation.getNumberOfPeople();
        this.totalPrice = reservation.getTotalPrice();
        
      //  this.arrangement = reservation.getArrangement();
        this.arrangementId = reservation.getArrangement().getId();
        this.arrangementName = reservation.getArrangement().getName();
        if (reservation.getChosenExcursions() != null) {
            this.chosenExcursions = new ArrayList<>();
            for (Excursion excursion : reservation.getChosenExcursions()) {
                this.chosenExcursions.add(new ExcursionDTO(excursion));
            }
        }
    }
}
