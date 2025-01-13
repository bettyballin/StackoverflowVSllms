/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.RequestDispatcher
 *  javax.servlet.ServletRequest
 *  javax.servlet.ServletResponse
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletForwarder {
    public void forwardRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/anotherServlet");
        try {
            requestDispatcher.forward((ServletRequest)httpServletRequest, (ServletResponse)httpServletResponse);
        }
        catch (Exception exception) {
            System.out.println("Error forwarding request: " + exception.getMessage());
        }
    }

    public static void main(String[] stringArray) {
        System.out.println("This is a servlet class and cannot be run as a standalone application.");
    }
}
