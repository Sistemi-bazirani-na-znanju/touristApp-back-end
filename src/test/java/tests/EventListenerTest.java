/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.stream.IntStream;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import tourstApp.model.Customer;
import tourstApp.model.Customer.Category;
import tourstApp.model.builder.CustomerBuilder;
import tourstApp.model.SuspiciousOperation;

public class EventListenerTest {
	
	
	protected final String ksessionName = "matchCancelledKsession";
    
	@Test
    public void matchCancelledTest() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kieContainer = ks.getKieClasspathContainer();
        KieSession ksession = kieContainer.newKieSession(ksessionName);
        
        ksession.addEventListener(new DebugAgendaEventListener());
        ksession.addEventListener(new DebugRuleRuntimeEventListener());

        Customer customer = new CustomerBuilder()
                .withId(1L)
                .withAge(24)
                .withCategory(Customer.Category.GOLD).build();

        
        ksession.insert(customer);
        
        //Generate 5 SuspiciousOperations for the customer and insert them
        //into the session.
        IntStream.range(0, 5)
                .mapToObj(i -> new SuspiciousOperation(customer, SuspiciousOperation.Type.SUSPICIOUS_AMOUNT))
                .forEach(so -> ksession.insert(so));

        ksession.fireAllRules();

        try{
            //The final result if we are testing the "Low category of GOLD customers with suspicious operations"
            //should be SILVER, but there is a conflict between 2 rules.
            assertThat(customer.getCategory(), is(Category.SILVER));
            fail("Exception expected");
        } catch (AssertionError ae){
            //Expected.
        }
    }

}
