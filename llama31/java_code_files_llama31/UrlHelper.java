/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 */
import javax.servlet.http.HttpServletRequest;

public class UrlHelper {
    public static String getContextUrl(HttpServletRequest httpServletRequest, String string) {
        return httpServletRequest.getContextPath() + string;
    }

    public static void main(String[] stringArray) {
    }
}
