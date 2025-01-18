import java.lang.String;
import java.lang.Integer;
import java.util.Optional;
public class HelloWorld_8 {
    public static void main(String[] args) {
        Optional<Integer> optionalValue = Optional.of(42);

        if (optionalValue.isPresent()) {
            System.out.println("Got a value: " + optionalValue.get());
        } else {
            System.out.println("No value present!");
        }
    }
}