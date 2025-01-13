/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;

public class MobileDetector {
    private static final Pattern mobileRegex = Pattern.compile("Android|webOS|iPhone|iPad|iPod|BlackBerry|Windows Phone");

    public static boolean isMobile(HttpServletRequest httpServletRequest) {
        String string = httpServletRequest.getHeader("User-Agent");
        Matcher matcher = mobileRegex.matcher(string);
        return matcher.find();
    }

    public static void main(String[] stringArray) {
        HttpServletRequest httpServletRequest = null;
        if (MobileDetector.isMobile(httpServletRequest)) {
            System.out.println("Display mobile version");
        } else {
            System.out.println("Display desktop version");
        }
    }
}
