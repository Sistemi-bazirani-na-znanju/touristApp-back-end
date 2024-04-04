package tourstApp.app;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import tourstApp.model.Item;
import tourstApp.model.OrderLine;
import tourstApp.util.DebugAgendaEventListener;

public class AgendaGroupExample {
	public static void main(String[] args) {
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
	}
}
