import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.net.URL;

import org.xhtmlrenderer.pdf.ITextRenderer;
import com.lowagie.text.DocumentException;

public class HtmlToPdfConverter {
    public void htmlToPdf(String src, String dest) throws IOException, DocumentException {
        try (InputStream in = new URL(src).openStream()) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromReader(new InputStreamReader(in));
            renderer.layout();

            try (OutputStream out = new FileOutputStream(dest)) {
                renderer.createPDF(out);
            }
        }
    }

    public static void main(String[] args) {
    }
}