/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 */
import javax.servlet.http.HttpServletRequest;

public class ButtonHandler {
    public static void handleButton(HttpServletRequest httpServletRequest) {
        if (httpServletRequest.getParameter("button1") != null) {
            System.out.println("button1 was clicked");
        } else if (httpServletRequest.getParameter("button2") != null) {
            System.out.println("button2 was clicked");
        } else if (httpServletRequest.getParameter("button3") != null) {
            System.out.println("button3 was clicked");
        }
    }

    public static void main(String[] stringArray) {
    }
}
