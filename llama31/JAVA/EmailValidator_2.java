import java.lang.String;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EmailValidator_2 {
    private static final String LOOSE_EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(LOOSE_EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

	public static void main(String[] args) {
	}
}