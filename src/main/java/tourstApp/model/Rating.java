package tourstApp.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating extends GenericEntity{
    
    @ManyToOne
    @JoinColumn(name = "arrangement_id")
    private Arrangement arrangement;

    @Column
    @NotNull
    private double ratingValue;

}
