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
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ZipDownloadServlet
extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String string = "C:\\zipfile.zip";
        httpServletResponse.setContentType("application/zip");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=zipfile.zip");
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(string));
             ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream((OutputStream)servletOutputStream);){
            int n;
            byte[] byArray = new byte[1024];
            while ((n = bufferedInputStream.read(byArray)) > 0) {
                bufferedOutputStream.write(byArray, 0, n);
            }
        }
    }
}
