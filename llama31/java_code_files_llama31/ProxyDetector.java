/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 */
import javax.servlet.http.HttpServletRequest;

public class ProxyDetector {
    public boolean isBehindProxy(HttpServletRequest httpServletRequest) {
        String string = httpServletRequest.getHeader("X-Forwarded-For");
        return string != null && !string.isEmpty();
    }

    public static void main(String[] stringArray) {
    }
}
