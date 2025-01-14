import java.lang.String;
import java.util.Optional;

public class Example_9 {
    public static void main(String[] args) {
        Optional<String> apple = Optional.empty();

        while (!apple.isPresent()) {
            apple = askForApple();
        }

        apple.ifPresentOrElse(
                a -> eatApple(a),
                () -> sulk()
        );
    }

    private static void sulk() {
        System.out.println("No apple available.");
    }

    private static void eatApple(String apple) {
        System.out.println("Eating " + apple);
    }

    // Simulate getting an apple
    private static Optional<String> askForApple() {
        return Optional.of("Green Apple");
    }
}