/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletOutputStream
 *  javax.servlet.http.HttpServletResponse
 */
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class DownloadFile {
    public void download(HttpServletResponse httpServletResponse, int n) throws Exception {
        httpServletResponse.setContentType("application/force-download");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"yourfile.pdf\"");
        httpServletResponse.setHeader("Content-Length", String.valueOf(n));
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
    }
}
