import java.util.ArrayList;
import java.util.List;

public class ReteExample {
    public static void main(String[] args) {
        // Define a simple rule
        Rule rule = new Rule("example", "x > 5", "x is greater than 5");

        // Create a RETE network
        Rete rete = new Rete();

        // Add the rule to the network
        rete.addRule(rule);

        // Create a fact (data)
        Fact fact = new Fact("x", 7);

        // Assert the fact into the network
        rete.assertFact(fact);

        // Run the network
        rete.run();
    }
}

class Rule {
    private String name;
    private String antecedent;
    private String consequent;

    public Rule(String name, String antecedent, String consequent) {
        this.name = name;
        this.antecedent = antecedent;
        this.consequent = consequent;
    }

    public String getAntecedent() {
        return antecedent;
    }

    public String getConsequent() {
        return consequent;
    }
}

class Fact {
    private String name;
    private Object value;

    public Fact(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}

class Rete {
    private List<Rule> rules;
    private List<Fact> facts;

    public Rete() {
        this.rules = new ArrayList<>();
        this.facts = new ArrayList<>();
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public void assertFact(Fact fact) {
        facts.add(fact);
    }

    public void run() {
        // Simplified RETE algorithm implementation
        for (Rule rule : rules) {
            if (evaluateAntecedent(rule.getAntecedent(), facts)) {
                executeConsequent(rule.getConsequent());
            }
        }
    }

    private boolean evaluateAntecedent(String antecedent, List<Fact> facts) {
        // Simplified evaluation of antecedent
        return antecedent.equals("x > 5") && facts.stream().anyMatch(fact -> fact.getName().equals("x") && (Integer) fact.getValue() > 5);
    }

    private void executeConsequent(String consequent) {
        // Simplified execution of consequent
        System.out.println(consequent);
    }
}