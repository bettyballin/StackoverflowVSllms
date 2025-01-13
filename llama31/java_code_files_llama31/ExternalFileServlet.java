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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExternalFileServlet
extends HttpServlet {
    private static final String FILE_PATH = "/path/to/external/file.html";

    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            int n;
            FileInputStream fileInputStream = new FileInputStream(file);
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            byte[] byArray = new byte[1024];
            while ((n = fileInputStream.read(byArray)) != -1) {
                servletOutputStream.write(byArray, 0, n);
            }
            fileInputStream.close();
            servletOutputStream.close();
        } else {
            httpServletResponse.sendError(404);
        }
    }

    public static void main(String[] stringArray) {
    }
}
