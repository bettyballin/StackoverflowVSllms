/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpSession
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecondPaymentServlet
extends HttpServlet {
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        HttpSession httpSession = httpServletRequest.getSession(true);
        String string = httpServletRequest.getParameter("step");
        if (string != null) {
            System.out.println("page number was " + string);
            httpSession.setAttribute("secPayStepNum", (Object)Integer.parseInt(string));
        } else {
            System.out.println("page number was null");
            httpSession.setAttribute("secPayStepNum", (Object)new Integer(0));
        }
    }

    public static void main(String[] stringArray) {
    }
}
