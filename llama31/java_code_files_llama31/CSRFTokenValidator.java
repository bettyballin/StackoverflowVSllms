/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 */
import javax.servlet.http.HttpServletRequest;

public class CSRFTokenValidator {
    public boolean isValid(HttpServletRequest httpServletRequest) {
        String string = httpServletRequest.getParameter("csrfToken");
        String string2 = (String)httpServletRequest.getSession().getAttribute("CSRF_TOKEN");
        return string != null && string.equals(string2);
    }

    public static void main(String[] stringArray) {
    }
}
