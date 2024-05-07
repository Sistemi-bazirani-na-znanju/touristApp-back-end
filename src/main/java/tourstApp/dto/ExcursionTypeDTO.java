package tourstApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tourstApp.model.Destination;
import tourstApp.model.ExcursionType;
import tourstApp.model.ExcursionTypeClass;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExcursionTypeDTO {

    private Integer id;

    private ExcursionType excursionType;

    public ExcursionTypeDTO(ExcursionTypeClass excursionTypeClass){
    
        this.id = excursionTypeClass.getId();
        this.excursionType = excursionTypeClass.getExcursionType();
    
    }

}
