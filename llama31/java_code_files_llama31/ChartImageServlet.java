/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletOutputStream
 *  javax.servlet.http.HttpServletResponse
 */
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class ChartImageServlet {
    public void doGet(HttpServletResponse httpServletResponse) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byArray = byteArrayOutputStream.toByteArray();
        httpServletResponse.setContentType("image/png");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        servletOutputStream.write(byArray);
        servletOutputStream.flush();
    }

    public static void main(String[] stringArray) {
    }
}
