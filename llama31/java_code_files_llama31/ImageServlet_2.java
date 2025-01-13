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

public class ImageServlet_2
extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String string = "/path/to/your/image.jpg";
        File file = new File(string);
        httpServletResponse.setContentType("image/jpeg");
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();){
            int n = 0;
            byte[] byArray = new byte[1024];
            while ((n = fileInputStream.read(byArray)) != -1) {
                servletOutputStream.write(byArray, 0, n);
            }
        }
    }

    public static void main(String[] stringArray) {
    }
}
