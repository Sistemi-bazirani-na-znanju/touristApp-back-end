package tourstApp.dto;

import java.time.LocalDateTime;
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
import tourstApp.model.RatingType;

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

    private LocalDateTime date;

    private List<ExcursionDTO> excursions;

    private List<RatingDTO> ratings;

    private boolean isNew;

    private boolean isPopular;

    private boolean isRecommended;

    private RatingType ratingType;


    public ArrangementDTO(Arrangement arrangement) {
        this.id = arrangement.getId();
        this.name = arrangement.getName();
        this.type = arrangement.getType();
        this.price = arrangement.getPrice();
        this.averageRating = arrangement.getAverageRating();
        this.date = arrangement.getDate();
        this.isNew = arrangement.isNew();
        this.isPopular = arrangement.isPopular();
        this.isRecommended = arrangement.isRecommended();
        this.ratingType = arrangement.getRatingType();
        
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
