package tourstApp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
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
public class ExcursionTypeClass extends GenericEntity{
    
    @Column(name = "excursion_type")
    @NotNull
    private ExcursionType excursionType;

    @ManyToMany(mappedBy = "excursionTypes")
    private List<User> users;

}
