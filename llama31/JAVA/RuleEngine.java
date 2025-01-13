import java.util.List;
import java.util.ArrayList;

// Rule.java
interface Rule {
    boolean evaluate(String[] keywords);
    String getAction();
}

// RuleEngine.java
class RuleEngine {
    private List<Rule> rules;

    public RuleEngine(List<Rule> rules) {
        this.rules = rules;
    }

    public String process(String[] keywords) {
        for (Rule rule : rules) {
            if (rule.evaluate(keywords)) {
                return rule.getAction();
            }
        }
        return null; // or some default action
    }
}

// RuleImplementation.java
class RuleImplementation implements Rule {
    private String keyword1;
    private int repetition;
    private String action;

    public RuleImplementation(String keyword1, int repetition, String action) {
        this.keyword1 = keyword1;
        this.repetition = repetition;
        this.action = action;
    }

    @Override
    public boolean evaluate(String[] keywords) {
        int count = 0;
        for (String keyword : keywords) {
            if (keyword.equals(keyword1)) {
                count++;
            }
        }
        return count >= repetition;
    }

    @Override
    public String getAction() {
        return action;
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        List<Rule> rules = new ArrayList<>();
        rules.add(new RuleImplementation("keyword1", 3, "do this"));
        rules.add(new RuleImplementation("keyword2", 2, "do that"));

        RuleEngine engine = new RuleEngine(rules);
        String[] keywords = {"keyword1", "keyword2", "keyword1", "keyword1"};
        String result = engine.process(keywords);
        System.out.println(result); // prints "do this"
    }
}