/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExamServlet
extends HttpServlet {
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        long l = System.currentTimeMillis();
        httpServletRequest.getSession().setAttribute("startTime", (Object)l);
    }

    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        long l = (Long)httpServletRequest.getSession().getAttribute("startTime");
        long l2 = System.currentTimeMillis() - l;
        httpServletRequest.setAttribute("elapsedTime", (Object)l2);
    }

    public static void main(String[] stringArray) {
    }
}
