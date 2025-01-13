import java.util.Optional;

public class OptionalExample {

    // A method that might return null
    public static String someMethodThatMightReturnNull() {
        // For demonstration, return a value or null conditionally
        return Math.random() < 0.5 ? "Value is present" : null;
    }

    public static void main(String[] args) {
        // Instead of:
        String x = someMethodThatMightReturnNull();
        if (x != null) {
            System.out.println("Using if statement: " + x);
        }

        // Use Optional:
        Optional<String> optionalX = Optional.ofNullable(someMethodThatMightReturnNull());
        optionalX.ifPresent(value -> System.out.println("Using Optional: " + value));
    }
}