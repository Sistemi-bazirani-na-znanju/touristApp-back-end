package tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import tourstApp.model.Order;

public class CollectTest {

    protected final String ksessionName = "collectKsession";

    @Test
    public void testInsertModifyAndDelete() {
    	KieServices ks = KieServices.Factory.get();
		KieContainer kieContainer = ks.getKieClasspathContainer();
        KieSession ksession = kieContainer.newKieSession(ksessionName);

        ksession.insert(new Order());
        ksession.insert(new Order());
        ksession.insert(new Order());
        int firedRules = ksession.fireAllRules();
        assertThat(1, equalTo(firedRules));
        
        ksession.insert(new Order());
        firedRules = ksession.fireAllRules();
        assertThat(1, equalTo(firedRules));
    }
}
