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
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyChat
extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ArrayList<String> myMessages = new ArrayList();

    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        String string = httpServletRequest.getReader().readLine();
        String[] stringArray = string.split(",");
        this.myMessages.add(stringArray[0] + " " + stringArray[1]);
        httpServletResponse.setContentType("text/html");
        PrintWriter printWriter = httpServletResponse.getWriter();
        Iterator<String> iterator = this.myMessages.iterator();
        while (iterator.hasNext()) {
            printWriter.println(iterator.next());
        }
    }

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        httpServletResponse.sendError(405);
    }

    public static void main(String[] stringArray) {
    }
}
