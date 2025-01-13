import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Agency1Validator extends EmailValidator {
    private static final String AGENCY1_PATTERN = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$";

    @Override
    public boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(AGENCY1_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
    }
}

// Assuming EmailValidator is an abstract class with isValidEmail method
abstract class EmailValidator {
    public abstract boolean isValidEmail(String email);
}