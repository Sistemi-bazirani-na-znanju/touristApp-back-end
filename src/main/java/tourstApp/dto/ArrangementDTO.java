package tourstApp.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tourstApp.model.Arrangement;
import tourstApp.model.ArrangementType;
import tourstApp.model.Excursion;
import tourstApp.model.Rating;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArrangementDTO {
    
    private Integer id;

    private String name;

    private ArrangementType type;

    private double price;

    private double averageRating;

    private List<ExcursionDTO> excursions;

    private List<RatingDTO> ratings;


    public ArrangementDTO(Arrangement arrangement) {
        this.id = arrangement.getId();
        this.name = arrangement.getName();
        this.type = arrangement.getType();
        this.price = arrangement.getPrice();
        this.averageRating = arrangement.getAverageRating();
        
        if (arrangement.getExcursions() != null) {
            this.excursions = new ArrayList<>();
            for (Excursion excursion : arrangement.getExcursions()) {
                this.excursions.add(new ExcursionDTO(excursion));
            }
        }
        
        if (arrangement.getRatings() != null) {
            this.ratings = new ArrayList<>();
            for (Rating rating : arrangement.getRatings()) {
                this.ratings.add(new RatingDTO(rating));
            }
        }
    }
    
}
