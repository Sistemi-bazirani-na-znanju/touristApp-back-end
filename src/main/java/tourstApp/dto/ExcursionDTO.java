package tourstApp.dto;

import tourstApp.model.Excursion;
import tourstApp.model.ExcursionType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExcursionDTO {

    private Integer id;

    private String name;

    private double price;

    private int numberOfPeopleRegistered;

    private ExcursionType type; 

    private double totalPrice;

    
    public ExcursionDTO(Excursion excursion){
        this.id = excursion.getId();
        this.name = excursion.getName();
        this.price = excursion.getPrice();
        this.numberOfPeopleRegistered = excursion.getNumberOfPeopleRegistered();
        this.type = excursion.getType();
        this.totalPrice = excursion.getTotalPrice();
    }
}
