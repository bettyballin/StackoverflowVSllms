import java.lang.String;
import java.util.regex.Pattern;

public class NumberValidator_1 {
    private static final Pattern NUMBER_PATTERN = Pattern.compile(
        "^[-+]?\\d{1,3}(?:,\\d{3})*(?:\\.\\d+)?(?:[eE][-+]?\\d+)?$"
    );

    public boolean isANumber(String s) {
        return NUMBER_PATTERN.matcher(s).matches();
    }

	public static void main(String[] args) {
	}
}