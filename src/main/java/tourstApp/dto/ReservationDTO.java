package tourstApp.dto;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tourstApp.model.Reservation;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {

    private Integer id;
    
    private int numberOfPeople;

    private double totalPrice;

    private List<ExcursionDTO> chosenExcursions;

    public ReservationDTO(Reservation reservation) {

        this.numberOfPeople = reservation.getNumberOfPeople();
        this.totalPrice = reservation.getTotalPrice();
        if (reservation.getChosenExcursions() != null) {
        this.chosenExcursions = reservation.getChosenExcursions().stream()
                                    .map(ExcursionDTO::new)
                                    .collect(Collectors.toList());
        }
    }
}
