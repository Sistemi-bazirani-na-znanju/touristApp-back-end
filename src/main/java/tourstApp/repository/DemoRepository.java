package tourstApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tourstApp.model.DemoModel;

public interface DemoRepository extends JpaRepository<DemoModel,Integer> {

}
