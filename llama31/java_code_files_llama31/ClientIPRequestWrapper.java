/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletRequestWrapper
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class ClientIPRequestWrapper
extends HttpServletRequestWrapper {
    public ClientIPRequestWrapper(HttpServletRequest httpServletRequest) {
        super(httpServletRequest);
    }

    public String getRemoteAddr() {
        String string = super.getHeader("X-Forwarded-For");
        if (string != null) {
            return string;
        }
        return super.getRemoteAddr();
    }

    public static void main(String[] stringArray) {
    }
}
