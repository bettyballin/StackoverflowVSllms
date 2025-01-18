import org.w3c.tidy.Tidy;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import org.w3c.dom.Document;

public class HtmlToXhtml {
    static String html = "<h1>Hello, world!<br/></h1>";
    public static void main(String args[]) throws IOException {
        // configure tidy to output only errors, as XML, and use the XHTML transitional DTD
        Tidy tidy = new Tidy();
        tidy.setXHTML(true);
        InputStream inputStream = new ByteArrayInputStream(html.getBytes());
        OutputStream outputStream = new FileOutputStream("file.xhtml");
        Document htmlDoc = tidy.parseDOM(inputStream, outputStream);
    }
}