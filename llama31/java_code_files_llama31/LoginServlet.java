/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet
extends HttpServlet {
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String string;
        String string2 = httpServletRequest.getParameter("j_username");
        boolean bl = this.authenticateUser(string2, string = httpServletRequest.getParameter("j_password"));
        if (bl) {
            httpServletResponse.sendRedirect("/protected-page.jsp");
        } else {
            httpServletResponse.sendRedirect("/error.jsp");
        }
    }

    private boolean authenticateUser(String string, String string2) {
        return true;
    }

    public static void main(String[] stringArray) throws Exception {
    }
}
