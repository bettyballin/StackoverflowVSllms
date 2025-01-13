import java.util.List;
import java.util.ArrayList;

// Define the Context class
class Context {
    private Dog dog;
    private String area;

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Dog getDog() {
        return dog;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }
}

// Define the Dog class
class Dog {
    private String name;
    private boolean hasCollar;

    public Dog(String name, boolean hasCollar) {
        this.name = name;
        this.hasCollar = hasCollar;
    }

    public String getName() {
        return name;
    }

    public boolean hasCollar() {
        return hasCollar;
    }
}

// Define the Rule interface
interface Rule {
    void evaluate(Context context);
}

// Define the DogCollarRule class
class DogCollarRule implements Rule {
    @Override
    public void evaluate(Context context) {
        if (context.getDog().hasCollar()) {
            System.out.println("The dog " + context.getDog().getName() + " has a collar.");
        } else {
            System.out.println("The dog " + context.getDog().getName() + " does not have a collar.");
        }
    }
}

// Define the RuleEngine class
class RuleEngine {
    private List<Rule> rules;

    public RuleEngine(List<Rule> rules) {
        this.rules = rules;
    }

    public void evaluate(Context context) {
        for (Rule rule : rules) {
            rule.evaluate(context);
        }
    }
}

public class RuleEvaluatorExample {
    public static void main(String[] args) {
        // Create a context object with relevant data
        Context context = new Context();
        context.setDog(new Dog("Fido", true)); // Dog with collar
        context.setArea("park");

        // Create a list of rules
        List<Rule> rules = new ArrayList<>();
        rules.add(new DogCollarRule());

        // Create a rule engine and evaluate rules
        RuleEngine engine = new RuleEngine(rules);
        engine.evaluate(context);
    }
}