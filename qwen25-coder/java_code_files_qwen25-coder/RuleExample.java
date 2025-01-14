import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class RuleExample {
    public static void main(final String[] args) {
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        KieSession ksession = kc.newKieSession("ksession-rules");

        // insert facts into the working memory
        ksession.insert(new Person("Alice"));
        ksession.insert(new Message("Hello"));

        // fire all rules in the stateful knowledge session
        ksession.fireAllRules();

        ksession.dispose(); // dispose the session
    }

    public static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Message {
        private String content;

        public Message(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }
    }
}