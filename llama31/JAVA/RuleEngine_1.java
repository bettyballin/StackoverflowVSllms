import java.util.List;

class Rule {
    private String name;

    public Rule(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean evaluate(Context context) {
        // You need to implement this method based on your rules
        return true; // For now, it always returns true
    }
}

class Context {
    // You need to implement this class based on your context
}

public class RuleEngine_1 {
    private List<Rule> rules;

    public RuleEngine(List<Rule> rules) {
        this.rules = rules;
    }

    public void evaluate(Context context) {
        for (Rule rule : rules) {
            if (rule.evaluate(context)) {
                // Rule matched, perform actions or return result
                System.out.println(rule.getName() + " matched");
            }
        }
    }

    public static void main(String[] args) {
        // You need to create instances of Rule and Context to test the RuleEngine
    }
}