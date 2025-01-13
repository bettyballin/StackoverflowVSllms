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

public class DynamicFileServlet
extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String string = "This is some dynamic data";
        httpServletResponse.setContentType("text/plain");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"dynamic_file.txt\"");
        httpServletResponse.getOutputStream().write(string.getBytes());
        httpServletResponse.getOutputStream().close();
    }

    public static void main(String[] stringArray) {
    }
}
