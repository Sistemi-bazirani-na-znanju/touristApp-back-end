package tourstApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tourstApp.model.Destination;
import tourstApp.model.Excursion;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DestinationDTO {
    
    private Integer id;

    private String destinationName;

    public DestinationDTO(Destination destination){
    
        this.id = destination.getId();
        this.destinationName = destination.getDestinationName();
    
    }
}
