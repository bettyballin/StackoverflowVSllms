import java.io.ByteArrayInputStream;
import java.net.URL;
import nu.xom.Builder;
import nu.xom.Document;

public class Test_12 {
    public static void main(String[] args) throws Exception {
        String html = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
                + "<html>\n"
                + "    <body>\n"
                + "\n"
                + "        Hello World!!!\n"
                + "   \n"
                + "</body> </html>"; // Your HTML content as a string. The document type declaration is included here; no need to include it separately later on.

        URL url = new URL("http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"); // Create this once in your application, and reuse the instance if necessary.

        Builder builder = new Builder(false); // Use non-validating parser to build the document as an in-memory model (easier to search/modify) rather than SAX events.

        Document doc = builder.build(new ByteArrayInputStream(html.getBytes()), url.toString()); // This builds a new document using the DTD defined in the HTML content.
    }
}