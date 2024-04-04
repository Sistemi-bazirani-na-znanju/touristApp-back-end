package tourstApp.app;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import tourstApp.model.Customer;
import tourstApp.model.Item;
import tourstApp.model.Order;
import tourstApp.model.OrderLine;
import tourstApp.util.DebugAgendaEventListener;

public class GlobalExample {

	public static void main(String[] args) {
		KieServices ks = KieServices.Factory.get();
		KieContainer kieContainer = ks.getKieClasspathContainer();
		KieSession kSession = kieContainer.newKieSession("ksession-rules");
		
		kSession.addEventListener(new DebugAgendaEventListener());
		
		kSession.setGlobal("comboCount", 2);
		
		Customer c1 = new Customer();
        c1.setAge(21);
        c1.setCategory(Customer.Category.NA);
        c1.setCustomerId((long) 21);
        c1.setName("Pera");
        c1.setEmail("pera@pera.pera");
        
        Order o = new Order();
        o.setCustomer(c1);
        o.setDate(new Date());
        List<OrderLine> l1 = new LinkedList<OrderLine>();
        
        OrderLine ol1 = new OrderLine();
        ol1.setItem(new Item((long)1,"i1", 123.0, 123.0));
        OrderLine ol2 = new OrderLine();
        ol2.setItem(new Item((long)2,"i2", 223.0, 223.0));
        OrderLine ol3 = new OrderLine();
        ol3.setItem(new Item((long)3,"i3", 293.0, 213.0));
        OrderLine ol4 = new OrderLine();
        ol4.setItem(new Item((long)4,"i4", 993.0, 1213.0));
        OrderLine ol5 = new OrderLine();
        ol5.setItem(new Item((long)5,"i5", 793.0, 1013.0));
        
        l1.add(ol1);
        l1.add(ol2);
        l1.add(ol3);
        l1.add(ol4);
        l1.add(ol5);
        
        o.setOrderLines(l1);
        
        System.out.println("Discount: " + o.getDiscount());
        
        kSession.insert(c1);
        kSession.insert(o);
        
        int fired = kSession.fireAllRules();
        System.out.println(fired);
       
        System.out.println("Discount: " + o.getDiscount());
	}

}
