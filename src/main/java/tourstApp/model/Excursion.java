package tourstApp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
public class Excursion extends GenericEntity{

    @ManyToOne
    @JoinColumn(name = "arrangement_id")
    private Arrangement arrangement;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private double price;

    @Column
    @NotNull
    private ExcursionType type; 

    @ManyToMany(mappedBy = "chosenExcursions")
    private List<Reservation> reservations;
}
