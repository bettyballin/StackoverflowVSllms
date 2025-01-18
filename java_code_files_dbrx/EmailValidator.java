import java.lang.String;
import java.util.regex.*;
public class EmailValidator {
    private static final Pattern EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

    public boolean isValidEmail(String email) {
        Matcher matcher = EMAIL_REGEX.matcher(email);
        return matcher.find();
    }

	public static void main(String[] args) {
	}
}