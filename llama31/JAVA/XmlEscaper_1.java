import org.apache.commons.text.StringEscapeUtils;

public class XmlEscaper_1_1 {
    public static void main(String[] args) {
        String attr = "some_value"; // Replace with actual value or method call
        String escXml = StringEscapeUtils.escapeXml11(attr);
        System.out.println(escXml);
    }
}