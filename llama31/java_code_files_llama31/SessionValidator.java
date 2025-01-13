/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpSession
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionValidator {
    private HttpServletRequest request;

    public SessionValidator(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    public Boolean checkIfSessionIsValid(String string) {
        HttpSession httpSession = this.request.getSession();
        return httpSession.getId().equals(string);
    }

    public static void main(String[] stringArray) {
    }
}
