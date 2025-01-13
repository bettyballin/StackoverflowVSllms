import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MobileDetector {
    private static final Pattern mobileRegex = Pattern.compile("Android|webOS|iPhone|iPad|iPod|BlackBerry|Windows Phone");

    public static boolean isMobile(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        Matcher matcher = mobileRegex.matcher(userAgent);
        return matcher.find();
    }

    public static void main(String[] args) {
        HttpServletRequest request = null; // Replace with actual HttpServletRequest instance
        if (MobileDetector.isMobile(request)) {
            System.out.println("Display mobile version");
        } else {
            System.out.println("Display desktop version");
        }
    }
}