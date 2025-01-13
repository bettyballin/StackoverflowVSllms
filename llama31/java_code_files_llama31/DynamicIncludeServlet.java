/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.RequestDispatcher
 *  javax.servlet.ServletException
 *  javax.servlet.ServletRequest
 *  javax.servlet.ServletResponse
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DynamicIncludeServlet
extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException {
        String string = this.getFileNameFromDatabaseOrOtherSource();
        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher(string);
        try {
            requestDispatcher.include((ServletRequest)httpServletRequest, (ServletResponse)httpServletResponse);
        }
        catch (IOException iOException) {
            throw new ServletException("Error including file: " + string, (Throwable)iOException);
        }
    }

    private String getFileNameFromDatabaseOrOtherSource() {
        return "example.jsp";
    }
}
