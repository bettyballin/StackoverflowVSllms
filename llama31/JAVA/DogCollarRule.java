import java.lang.String;

// Define the Context class
class Context {
    private Dog dog;
    private String area;

    public Context(Dog dog, String area) {
        this.dog = dog;
        this.area = area;
    }

    public Dog getDog() {
        return dog;
    }

    public String getArea() {
        return area;
    }
}

// Define the Dog class
class Dog {
    private boolean hasCollar;

    public Dog(boolean hasCollar) {
        this.hasCollar = hasCollar;
    }

    public boolean hasCollar() {
        return hasCollar;
    }
}

public interface Rule {
    boolean evaluate(Context context);
    String getName();
}

public class DogCollarRule implements Rule {
    @Override
    public boolean evaluate(Context context) {
        // Logic to check if dog has collar in park area
        return context.getDog().hasCollar() && context.getArea().equals("park");
    }

    @Override
    public String getName() {
        return "Dog must have collar in area park";
    }

    public static void main(String[] args) {
        // Create a Dog and Context instance
        Dog dog = new Dog(true);
        Context context = new Context(dog, "park");

        // Create a DogCollarRule instance and evaluate it
        DogCollarRule rule = new DogCollarRule();
        System.out.println(rule.getName() + ": " + rule.evaluate(context));
    }
}