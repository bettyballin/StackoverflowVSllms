import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebAddressValidator {
    private static final Pattern pattern = Pattern.compile(
            "^((http|https)://)?([a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})(:[0-9]{1,5})?(/.*)?$"
    );

    public static boolean isValidWebAddress(String input) {
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidWebAddress("http://www.google.com")); // true
        System.out.println(isValidWebAddress("www.vg.no")); // true
        System.out.println(isValidWebAddress("tv2.no")); // true
        System.out.println(isValidWebAddress("not a web address")); // false
    }
}