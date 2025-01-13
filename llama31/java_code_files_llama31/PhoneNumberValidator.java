/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
    private static final Pattern phonePattern = Pattern.compile("^\\+?1?\\s?\\(?([0-9]{3})\\)?[-\\s.]?\\s?([0-9]{3})\\s?[-\\s.]?\\s?([0-9]{4})\\s?(?:x|ext)?\\s?([0-9]{1,5})?$");

    public static boolean isValidPhoneNumber(String string) {
        Matcher matcher = phonePattern.matcher(string);
        return matcher.matches();
    }

    public static void main(String[] stringArray) {
        System.out.println(PhoneNumberValidator.isValidPhoneNumber("1-234-567-8901"));
        System.out.println(PhoneNumberValidator.isValidPhoneNumber("1-234-567-8901 x1234"));
        System.out.println(PhoneNumberValidator.isValidPhoneNumber("1 (234) 567-8901"));
        System.out.println(PhoneNumberValidator.isValidPhoneNumber("12345678901"));
        System.out.println(PhoneNumberValidator.isValidPhoneNumber(" invalid phone number"));
    }
}
