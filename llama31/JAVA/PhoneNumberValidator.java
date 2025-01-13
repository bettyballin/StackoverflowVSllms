import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
    private static final Pattern phonePattern = Pattern.compile("^\\+?1?\\s?\\(?([0-9]{3})\\)?[-\\s.]?\\s?([0-9]{3})\\s?[-\\s.]?\\s?([0-9]{4})\\s?(?:x|ext)?\\s?([0-9]{1,5})?$");

    public static boolean isValidPhoneNumber(String phoneNumber) {
        Matcher matcher = phonePattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidPhoneNumber("1-234-567-8901")); // true
        System.out.println(isValidPhoneNumber("1-234-567-8901 x1234")); // true
        System.out.println(isValidPhoneNumber("1 (234) 567-8901")); // true
        System.out.println(isValidPhoneNumber("12345678901")); // true
        System.out.println(isValidPhoneNumber(" invalid phone number")); // false
    }
}