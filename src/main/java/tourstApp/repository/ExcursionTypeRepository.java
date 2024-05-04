package tourstApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tourstApp.model.Destination;
import tourstApp.model.ExcursionType;
import tourstApp.model.ExcursionTypeClass;

public interface ExcursionTypeRepository extends JpaRepository<ExcursionTypeClass, Integer> {

    @Query("SELECT etc FROM ExcursionTypeClass etc WHERE etc.excursionType = :excursionType")
    ExcursionTypeClass findByExcursionType(@Param("excursionType") ExcursionType excursionType);
}