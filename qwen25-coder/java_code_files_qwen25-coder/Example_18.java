import java.lang.String;
import java.util.Optional;

public class Example_18 {
    public static void main(String[] args) {
        String x = getString(); // This might return null

        Optional<String> optionalX = Optional.ofNullable(x);

        optionalX.ifPresent(value -> {
            // Use the value here if it's not null
            System.out.println(value);
        });

        // Alternatively, provide a default value or throw an exception
        String result = optionalX.orElse("default");
        // or
        String nonNullResult = optionalX.orElseThrow(() -> new RuntimeException("Value was null"));
    }

    static String getString() {
        // Some logic that might return null
        return null;
    }
}