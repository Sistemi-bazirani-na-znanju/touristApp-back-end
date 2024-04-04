package tourstApp.service;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tourstApp.model.DemoModel;
import tourstApp.model.Item;
import tourstApp.model.OrderLine;
import tourstApp.repository.DemoRepository;
import tourstApp.util.DebugAgendaEventListener;

@Service
public class DemoService {

    @Autowired
    DemoRepository repository;

    public int returnResult(){
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kSession = kc.newKieSession("agenda-rules");

        kSession.addEventListener(new DebugAgendaEventListener());

        Item item = new Item("pencil", 1.5, 2.0);
        OrderLine orderLine = new OrderLine();
        orderLine.setItem(item);
        orderLine.setQuantity(11);

        kSession.insert(orderLine);

        int firedRules = kSession.fireAllRules();

        System.out.println(firedRules);

        kSession.getAgenda().getAgendaGroup("promotions").setFocus();

        firedRules = kSession.fireAllRules();

        System.out.println(firedRules);
        return firedRules;
    }

    public DemoModel getDemoById(Integer id){
        return repository.findById(id).orElseGet(null);
    }


}
