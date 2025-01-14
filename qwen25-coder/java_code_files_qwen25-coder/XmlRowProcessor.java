import java.sql.ResultSet;
import java.sql.SQLException;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlRowProcessor {
    public static void main(String[] args) throws SAXException, SQLException {
        // foreach column of each row
        ContentHandler xmlHandler = new DefaultHandler();
        String uri = "";
        String lname = "";
        Attributes attributes = null;
        xmlHandler.startElement(uri, lname, "column", attributes);

        ResultSet rs = null;
        int i = 1;
        String chars = rs.getString(i);

        // Replace invalid XML characters
        chars = chars.replaceAll("[^\\x09\\x0A\\x0D\\x20-\\uD7FF\\uE000-\\uFFFD\\u10000-\\u10FFFF]", "");

        xmlHandler.characters(chars.toCharArray(), 0, chars.length());
        xmlHandler.endElement(uri, lname, "column");
    }
}