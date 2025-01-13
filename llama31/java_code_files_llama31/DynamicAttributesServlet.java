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
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DynamicAttributesServlet
extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        Map map = (Map)httpServletRequest.getAttribute("dynamicAttributesVar");
        String string = (String)map.get("someUnexpectedAttribute");
        PrintWriter printWriter = httpServletResponse.getWriter();
        printWriter.println(string);
    }

    public static void main(String[] stringArray) {
        System.out.println("This is a servlet and cannot be run directly with javac.");
    }
}
