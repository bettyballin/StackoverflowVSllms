/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.ServletRequest
 *  javax.servlet.ServletResponse
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletController
extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException {
        httpServletRequest.setAttribute("decorator", (Object)"layout-main");
        try {
            this.getServletContext().getRequestDispatcher("/jsp/main.jsp").forward((ServletRequest)httpServletRequest, (ServletResponse)httpServletResponse);
        }
        catch (Exception exception) {
            throw new ServletException((Throwable)exception);
        }
    }

    public static void main(String[] stringArray) {
    }
}
