import java.lang.String;
import java.util.regex.Pattern;

public class Main_644 {
    public static void main(String[] args) {
        String input = "HelloWorld123.";
        if (Pattern.matches("^[a-zA-Z0-9\\.]+$", input)) {
            System.out.println("Input is valid");
        } else {
            System.out.println("Input is not valid");
        }
    }
}