/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet
extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String string = httpServletRequest.getParameter("token");
        if (this.verifyToken(string)) {
            System.out.println("Access granted");
        } else {
            httpServletResponse.setStatus(401);
        }
    }

    private boolean verifyToken(String string) {
        return true;
    }

    public static void main(String[] stringArray) {
        System.out.println("FormServlet main method called");
    }
}
