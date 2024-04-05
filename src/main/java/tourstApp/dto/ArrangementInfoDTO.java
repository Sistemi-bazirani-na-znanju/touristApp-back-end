package tourstApp.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tourstApp.model.ArrangementType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArrangementInfoDTO {
    
    private ArrangementType type;

    private double price;

    private double averageRating;
    
}
