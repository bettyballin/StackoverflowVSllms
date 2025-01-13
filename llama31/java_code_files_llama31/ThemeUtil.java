/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpSession
 */
import javax.servlet.http.HttpSession;

public class ThemeUtil {
    String theme;

    public ThemeUtil(HttpSession httpSession) {
        this.theme = (String)httpSession.getAttribute("theme");
    }

    public static void main(String[] stringArray) {
    }
}
