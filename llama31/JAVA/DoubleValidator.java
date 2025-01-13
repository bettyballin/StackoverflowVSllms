import java.lang.String;

public class DoubleValidator {
    public static void main(String[] args) {
        String input = "123.45"; // replace with your input
        try {
            Double.parseDouble(input);
            System.out.println("Valid double");
        } catch (NumberFormatException e) {
            System.out.println("Invalid double");
        }
    }
}