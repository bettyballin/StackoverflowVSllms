import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UserAgentRedirector {
    public static void main(String[] args) {
        String userAgent = "Mozilla/5.0 (iPhone; CPU iPhone OS 14_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0 Mobile/15E148 Safari/604.1";
        if (isMobileUserAgent(userAgent)) {
            System.out.println("Redirect to mobile site");
        } else {
            System.out.println("Do not redirect");
        }
    }

    public static boolean isMobileUserAgent(String userAgent) {
        String pattern = ".*Mobile.*|.*Android.*|.*iPhone.*|.*iPad.*|.*iPod.*|.*BlackBerry.*";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(userAgent);
        return matcher.matches();
    }
}