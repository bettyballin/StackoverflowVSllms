import java.lang.String;
import java.util.regex.Pattern;

public class SQLInjectionDetector {
    private static final String SQL_PATTERN = "\\b(SELECT|INSERT|UPDATE|DELETE|DROP|CREATE|ALTER|TRUNCATE|EXEC|UNION|OR|AND)\\b";

    public boolean detectSQLInjection(String input) {
        Pattern pattern = Pattern.compile(SQL_PATTERN, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(input).find();
    }

	public static void main(String[] args) {
	}
}