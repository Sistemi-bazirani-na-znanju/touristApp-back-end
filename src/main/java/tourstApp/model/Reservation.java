package tourstApp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
public class Reservation extends GenericEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;


    @Column
    @NotNull
    private int numberOfPeople;

    @Column
    @NotNull
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "arrangement_id")
    private Arrangement arrangement;
    
    @ManyToMany( fetch = FetchType.LAZY)
    @JoinTable(
        name = "reservation_excursion",
        joinColumns = @JoinColumn(name = "reservation_id"),
        inverseJoinColumns = @JoinColumn(name = "excursion_id")
    )
    private List<Excursion> chosenExcursions;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
