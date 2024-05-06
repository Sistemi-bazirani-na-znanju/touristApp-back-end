package tourstApp.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Arrangement extends GenericEntity{

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private ArrangementType type;

    @Column
    @NotNull
    private double price;

    @Column
    @NotNull
    private double averageRating;

    @Column
    @NotNull
    private LocalDateTime date;

    @Column
    private boolean isNew;

    @Column
    private boolean isPopular;

    @Column
    private boolean isRecommended;

    @Nullable
    private Integer numberOfRatings;

    @Nullable
    private RatingType ratingType;

    @Column
    @Nullable
    private Integer recommendationPoints;

    
    @OneToMany(mappedBy = "arrangement", fetch = FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL)
    private List<Excursion> excursions;

    @OneToMany(mappedBy = "arrangement", fetch = FetchType.EAGER, cascade = javax.persistence.CascadeType.ALL)
    private List<Rating> ratings;

    public void setExcursions(List<Excursion> excursions) {
        this.excursions = excursions;
        if(excursions != null) {
            excursions.forEach(excursion -> excursion.setArrangement(this));
        }
    }
  
    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
        if(ratings != null) {
            ratings.forEach(excursion -> excursion.setArrangement(this));
        }
    }

}


