/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebAddressValidator {
    private static final Pattern pattern = Pattern.compile("^((http|https)://)?([a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})(:[0-9]{1,5})?(/.*)?$");

    public static boolean isValidWebAddress(String string) {
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static void main(String[] stringArray) {
        System.out.println(WebAddressValidator.isValidWebAddress("http://www.google.com"));
        System.out.println(WebAddressValidator.isValidWebAddress("www.vg.no"));
        System.out.println(WebAddressValidator.isValidWebAddress("tv2.no"));
        System.out.println(WebAddressValidator.isValidWebAddress("not a web address"));
    }
}
