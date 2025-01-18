import java.io.ByteArrayInputStream;
import javax.xml.parsers.*;
import org.w3c.dom.*;  // or nu.validator.htmlparser.* for faster HTML parsing

public class UnescapeHtml {
    public static String unescapeHtml(String value) throws Exception {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        return builder.parse(new ByteArrayInputStream(("<textarea>" + value + "</textarea>").getBytes("UTF-8"))).getTextContent();
    }
}