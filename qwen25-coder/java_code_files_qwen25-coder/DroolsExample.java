import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsExample {
    public static void main(final String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ksession-rules");

        // Insert facts into the session
        kSession.insert(new Variable("someVariable", true));
        for (int i = 0; i < 34; i++) {
            kSession.insert(new Variable("var_" + i, true));
        }
        for (int i = 0; i < 22; i++) {
            kSession.insert(new Variable("var_34_" + i, false));
        }

        // Variables to be equal in complex condition
        kSession.insert(new Variable("variableA", "testValue"));
        kSession.insert(new Variable("variableB", "testValue"));

        // Fire the rules
        kSession.fireAllRules();
    }
}

class Variable {
    private String name;
    private Object value;

    public Variable(String name, boolean value) {
        this.name = name;
        this.value = value;
    }

    public Variable(String name, String value) {
        this.name = name;
        this.value = value;
    }
}