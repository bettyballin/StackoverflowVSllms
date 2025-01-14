import java.lang.String;
public class ArgumentValidator {
    public static void Function(int i, String s) {
        if (i <= 0) {
            throw new IllegalArgumentException("Argument 'i' must be greater than zero.");
        }
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Argument 's' cannot be null or empty.");
        }
    }
    public static void main(String[] args) {
    }
}