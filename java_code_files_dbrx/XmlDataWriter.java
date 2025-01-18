import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.ContentHandler;

public class XmlDataWriter {

    public void writeXmlData(ResultSet rs, ResultSetMetaData rsmd, ContentHandler xmlHandler) throws SQLException, SAXException {

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            String columnName = rsmd.getColumnName(i);
            xmlHandler.startElement("", "", "column", new AttributesImpl());
            String chars = rs.getString(i);
            if (isXML10Valid(chars)) { // Check for XML 1.0 valid characters
                xmlHandler.characters(chars.toCharArray(), 0, chars.length());
            } else { // Replace or remove invalid characters
                String replacement = "\uFFFD"; // Replacement character ('\uFFFD') in Unicode standard for unknown/unrepresentable characters

                chars = chars.replace("&#26;", replacement);
                xmlHandler.characters(chars.toCharArray(), 0, chars.length());
            }
            xmlHandler.endElement("", "", "column");
        }
    }

    // Helper method to check if a string contains only valid XML 1.0 characters
    public static boolean isXML10Valid(String chars) {
        if (chars == null || chars.isEmpty()) {
            return true;
        }
        for (int i = 0; i < chars.length(); i++) {
            if (!isXML10Valid(chars.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Helper method to check if a character is a valid XML 1.0 character
    public static boolean isXML10Valid(char c) {
        return (c == 0x9) || (c == 0xA) || (c == 0xD) ||
               ((c >= 0x20) && (c <= 0xD7FF)) ||
               ((c >= 0xE000) && (c <= 0xFFFD)) ||
               ((c >= 0x10000) && (c <= 0x10FFFF));
    }

    public static void main(String[] args) {
        // Main method remains empty
    }
}