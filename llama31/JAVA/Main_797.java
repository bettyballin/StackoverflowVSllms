import java.sql.ResultSet;
import java.sql.SQLException;

public class Main_797 {
    public static void main(String[] args) throws SQLException {
        ResultSet rs = null; // initialize ResultSet
        int i = 0; // initialize column index
        XmlHandler xmlHandler = new XmlHandler(); // initialize XmlHandler

        // Since ResultSet is null, we can't actually call getString on it.
        // For demonstration purposes, let's assume we have a string.
        String chars = "Example String with <XML> tags";
        String escapedChars = escapeXml(chars);
        xmlHandler.characters(escapedChars.toCharArray(), 0, escapedChars.length());
    }

    // Simple function to escape XML special characters
    public static String escapeXml(String input) {
        return input.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#039;");
    }
}

class XmlHandler {
    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}