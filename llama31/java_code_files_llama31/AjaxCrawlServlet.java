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

public class AjaxCrawlServlet
extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String string = httpServletRequest.getRequestURL().toString();
        if (string.contains("#!")) {
            String string2 = string.replace("#!", "?_escaped_fragment_=");
            httpServletResponse.getWriter().write(this.getStaticHtmlContent(string2));
        }
    }

    private String getStaticHtmlContent(String string) {
        return "";
    }

    public static void main(String[] stringArray) {
    }
}
