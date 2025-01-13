import org.apache.commons.text.StringEscapeUtils;

public class EscapeXmlExample {
    public static void main(String[] args) {
        String attrValue = "Example <value> with & special characters.";
        
        String escXml = StringEscapeUtils.escapeXml4(attrValue);
        
        System.out.println("Escaped XML: " + escXml);
    }
}