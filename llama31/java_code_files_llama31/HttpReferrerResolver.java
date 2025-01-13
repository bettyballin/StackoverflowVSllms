/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 */
import javax.servlet.http.HttpServletRequest;

public class HttpReferrerResolver {
    public static void main(String[] stringArray) {
        HttpServletRequest httpServletRequest = null;
        String string = HttpReferrerResolver.getReferrer(httpServletRequest);
        if (string != null) {
            System.out.println("Referrer: " + string);
        } else {
            System.out.println("Referrer is unknown");
        }
    }

    public static String getReferrer(HttpServletRequest httpServletRequest) {
        if (httpServletRequest == null) {
            return null;
        }
        return httpServletRequest.getHeader("referer");
    }
}
