/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.ServletOutputStream
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JarServlet
extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        int n;
        String string = "PublicJar.jar";
        String string2 = "/WEB-INF/lib/" + string;
        InputStream inputStream = this.getServletContext().getResourceAsStream(string2);
        if (inputStream == null) {
            httpServletResponse.setStatus(404);
            return;
        }
        httpServletResponse.setContentType("application/java-archive");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"" + string + "\"");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        byte[] byArray = new byte[1024];
        while ((n = inputStream.read(byArray)) != -1) {
            servletOutputStream.write(byArray, 0, n);
        }
        inputStream.close();
        servletOutputStream.close();
    }

    public static void main(String[] stringArray) {
    }
}
