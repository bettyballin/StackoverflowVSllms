/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletOutputStream
 *  javax.servlet.http.HttpServletResponse
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.RestController
 */
import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdfController {
    @GetMapping(value={"/pdf"})
    public void showPdf(HttpServletResponse httpServletResponse) throws IOException {
        byte[] byArray = this.fetchPdfViaWebService();
        httpServletResponse.setContentType("application/pdf");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=example.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        servletOutputStream.write(byArray);
        servletOutputStream.flush();
        servletOutputStream.close();
    }

    private byte[] fetchPdfViaWebService() {
        return new byte[0];
    }

    public static void main(String[] stringArray) {
    }
}
