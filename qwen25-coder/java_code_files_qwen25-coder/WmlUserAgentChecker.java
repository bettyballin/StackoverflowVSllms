import java.lang.String;
public class WmlUserAgentChecker {
// Example of checking user agent for additional testing scenarios
public boolean shouldTestForWml(String userAgent) {
    String[] wmlBrowsers = {
        "BlackBerry",
        "Blazer", // Palm OS browser
        "MOT-", // Motorola devices often start with MOT-
        "UP.Browser"
    };
    for (String browser : wmlBrowsers) {
        if (userAgent.contains(browser)) {
            return true;
        }
    }
    return false;
}
    public static void main(String[] args) {
    }
}