import java.lang.String;
public class AlphanumericValidator {
    public boolean isAlphanumericAndDot(String input) {
        return input.matches("[a-zA-Z0-9.]+");
    }
    public static void main(String[] args) {
    }
}