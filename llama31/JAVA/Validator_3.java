import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Validator_3_3 {
    public static void main(String[] args) {
        String userInput = "test@example.com"; // replace with your input
        if (!userInput.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            System.out.println("Invalid input");
        } else {
            System.out.println("Valid input");
        }
    }
}