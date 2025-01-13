/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpSession
 */
import javax.servlet.http.HttpSession;

public class SessionManager {
    public static void main(String[] stringArray) {
        Object var1_1 = null;
        HttpSession httpSession = var1_1.getSession();
        httpSession.setAttribute("foo", (Object)"bar");
    }
}
