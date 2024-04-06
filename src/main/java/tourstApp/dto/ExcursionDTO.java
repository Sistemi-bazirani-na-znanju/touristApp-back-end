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

    private ExcursionType type; 


    
    public ExcursionDTO(Excursion excursion){
        this.id = excursion.getId();
        this.name = excursion.getName();
        this.price = excursion.getPrice();
        this.type = excursion.getType();
    }
}
