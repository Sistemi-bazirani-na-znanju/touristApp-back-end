package tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import tourstApp.model.Item;
import tourstApp.model.Order;
import tourstApp.model.OrderLine;

public class AccumulateTest {

    protected final String ksessionName = "accumKsession";

    @Test
    public void testInsertModifyAndDelete() {
    	KieServices ks = KieServices.Factory.get();
		KieContainer kieContainer = ks.getKieClasspathContainer();
        KieSession ksession = kieContainer.newKieSession(ksessionName);
        
        //first order will have 29 items, but only 9 items with sale price over 20
        Order order1 = createCheapItemsOrder();
        assertThat(order1.getTotalItems(), equalTo(29));
        //second order will have 10 items, all with sale price over 20
        Order order2 = createExpensiveItemsOrder();
        assertThat(order2.getTotalItems(), equalTo(10));
        ksession.insert(order1);
        ksession.insert(order2);
        //so the rule should fire for only one of the orders
        int firedRules = ksession.fireAllRules();
        assertThat(1, equalTo(firedRules));

        assertThat(order1.getDiscount(), nullValue());
        
        assertThat(order2.getDiscount(), notNullValue());
        assertThat(order2.getDiscount().getPercentage(), notNullValue());
        assertThat(order2.getDiscount().getPercentage(), equalTo(0.05));
    }
    
    private Order createExpensiveItemsOrder() {
        Order order = new Order();
        OrderLine line = new OrderLine();
        line.setItem(new Item("nice phone case", 10.00, 21.00));
        line.setQuantity(10);
        List<OrderLine> orderLines = new ArrayList<OrderLine>();
        orderLines.add(line);
        order.setOrderLines(orderLines);
        return order;
    }

    private Order createCheapItemsOrder() {
        Order order = new Order();
        OrderLine line1 = new OrderLine();
        line1.setItem(new Item("pencil", 0.50, 0.80));
        line1.setQuantity(20);
        OrderLine line2 = new OrderLine();
        line2.setItem(new Item("nice phone case", 10.00, 21.00));
        line2.setQuantity(9);
        List<OrderLine> orderLines = new ArrayList<OrderLine>();
        orderLines.add(line1);
        orderLines.add(line2);
        order.setOrderLines(orderLines);
        return order;
    }

}
