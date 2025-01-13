/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NextPageServlet
extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String string = httpServletRequest.getParameter("param1");
        String string2 = httpServletRequest.getParameter("param2");
        httpServletResponse.setContentType("text/plain");
        PrintWriter printWriter = httpServletResponse.getWriter();
        printWriter.println("Param 1: " + string);
        printWriter.println("Param 2: " + string2);
    }
}
