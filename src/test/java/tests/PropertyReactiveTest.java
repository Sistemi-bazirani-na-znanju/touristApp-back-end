package tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import tourstApp.model.Item;
import tourstApp.model.Order;
import tourstApp.model.OrderLine;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class PropertyReactiveTest {

    protected final String ksessionName = "propertyReactiveKsession";

    @Test
    public void testLargeOrder() throws Exception {
    	KieServices ks = KieServices.Factory.get();
		KieContainer kieContainer = ks.getKieClasspathContainer();
        KieSession ksession = kieContainer.newKieSession(ksessionName);

        Order order = createLargeOrder();
        order.setDate(new SimpleDateFormat("dd-MM-yyyy").parse("19-2-2023"));
        ksession.insert(order);
        int firedRules = ksession.fireAllRules();
        assertThat(firedRules, equalTo(1));
        assertThat(order.getDiscount().getPercentage(), equalTo(0.03));

        String add = "add";
        ksession.insert(add);
        firedRules = ksession.fireAllRules();
        assertThat(firedRules, equalTo(2));
        assertThat(order.getDiscount().getPercentage(), equalTo(0.05));
    }

    private Order  createLargeOrder() {
        Order order = new Order();
        List<OrderLine> orderLines = new ArrayList<OrderLine>();
        OrderLine orderLine1 = new OrderLine();
        orderLine1.setItem(new Item("paper block", 5.00, 8.00));
        orderLine1.setQuantity(5);
        OrderLine orderLine2 = new OrderLine();
        orderLine2.setItem(new Item("pen", 1.00, 15.0));
        orderLine2.setQuantity(10);
        orderLines.add(orderLine1);
        orderLines.add(orderLine2);
        order.setOrderLines(orderLines);
        return order;
    }
}    
