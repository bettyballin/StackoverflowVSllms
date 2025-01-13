/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 */
import javax.servlet.http.HttpServletRequest;

public class IpAddressFilter {
    private static final String INTERNAL_IP_REGEX = "^10\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$";

    public boolean isInternalRequest(HttpServletRequest httpServletRequest) {
        String string = httpServletRequest.getRemoteAddr();
        return string.matches(INTERNAL_IP_REGEX);
    }

    public static void main(String[] stringArray) {
    }
}
