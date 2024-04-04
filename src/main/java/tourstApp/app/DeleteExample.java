package tourstApp.app;

import java.util.Date;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import tourstApp.model.Coupon;
import tourstApp.util.DebugAgendaEventListener;

public class DeleteExample {

	public static void main(String[] args) {
		KieServices ks = KieServices.Factory.get();
		KieContainer kieContainer = ks.getKieClasspathContainer();
		KieSession kSession = kieContainer.newKieSession("ksession-rules");
		
		kSession.addEventListener(new DebugAgendaEventListener());
        
		Coupon c = new Coupon();
		c.setValidUntil(new Date(System.currentTimeMillis() - 1000000));
		
		kSession.insert(c);
		kSession.fireAllRules();
		
		
	}

}
