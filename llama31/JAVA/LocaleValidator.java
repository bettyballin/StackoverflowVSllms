import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.json.JSONObject;

public class LocaleValidator {
    private static final String LOCALE_RULES_FILE = "locale-rules.json";

    public boolean isValidInput(String input, String locale) {
        String regex = getRegexFromLocaleRules(locale);
        return Pattern.matches(regex, input);
    }

    private String getRegexFromLocaleRules(String locale) {
        try {
            File file = new File(LOCALE_RULES_FILE);
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            JSONObject jsonObject = new JSONObject(content);
            return jsonObject.getString(locale);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + LOCALE_RULES_FILE);
            return null;
        }
    }

    public static void main(String[] args) {
        LocaleValidator validator = new LocaleValidator();
        // Example usage:
        // System.out.println(validator.isValidInput("input", "locale"));
    }
}