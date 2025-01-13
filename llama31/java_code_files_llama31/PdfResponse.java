/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletResponse
 */
import javax.servlet.http.HttpServletResponse;

public class PdfResponse {
    public void setPdfResponse(HttpServletResponse httpServletResponse) {
        httpServletResponse.setContentType("application/pdf");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"yourfile.pdf\"");
    }
}
