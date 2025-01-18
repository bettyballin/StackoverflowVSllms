import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

// Processing Logic - Analyzer
public class Analyzer {
    private KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();

    public void analyze(UserInput input) {
        KieSession ksession = kc.newKieSession("rulesKS");
        ksession.insert(input);
        ksession.fireAllRules(); // this will match any relevant rules based on current fact and execute actions if a rule matches
    }

    public static void main(String[] args) {
    }
}

// Dummy UserInput class
class UserInput {
    // Fields and methods can be added here as needed
}