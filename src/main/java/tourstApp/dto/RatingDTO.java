package tourstApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tourstApp.model.Rating;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RatingDTO {
    
    private Integer id;

    private double ratingValue;

    public RatingDTO(Rating rating){
        this.id = rating.getId();
        this.ratingValue = rating.getRatingValue();
    }
}
