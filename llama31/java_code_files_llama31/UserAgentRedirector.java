/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserAgentRedirector {
    public static void main(String[] stringArray) {
        String string = "Mozilla/5.0 (iPhone; CPU iPhone OS 14_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0 Mobile/15E148 Safari/604.1";
        if (UserAgentRedirector.isMobileUserAgent(string)) {
            System.out.println("Redirect to mobile site");
        } else {
            System.out.println("Do not redirect");
        }
    }

    public static boolean isMobileUserAgent(String string) {
        String string2 = ".*Mobile.*|.*Android.*|.*iPhone.*|.*iPad.*|.*iPod.*|.*BlackBerry.*";
        Pattern pattern = Pattern.compile(string2);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
