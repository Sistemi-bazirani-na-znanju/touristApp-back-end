package tourstApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tourstApp.model.Excursion;

public interface ExcursionRepository extends JpaRepository<Excursion, Integer>{
    
}
