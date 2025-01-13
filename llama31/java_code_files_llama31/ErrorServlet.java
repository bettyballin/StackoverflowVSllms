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
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorServlet
extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String string = (String)httpServletRequest.getAttribute("javax.servlet.forward.request_uri");
        if (string != null && string.contains("/admin/")) {
            httpServletRequest.getRequestDispatcher("/adminError.jsp").forward((ServletRequest)httpServletRequest, (ServletResponse)httpServletResponse);
        } else {
            httpServletRequest.getRequestDispatcher("/userError.jsp").forward((ServletRequest)httpServletRequest, (ServletResponse)httpServletResponse);
        }
    }
}
