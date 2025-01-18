import java.lang.String;
import org.apache.commons.text.StringEscapeUtils;

public class XmlBuilder {
    
    public static void main(String[] args) {
        // Initialize xml
        String xml = "";

        // Create an attribute
        Attr attr = new Attr("myAttr", "Some & value <to> escape");

        // Escape XML
        String escXml = StringEscapeUtils.escapeXml10(attr.get()); // escapeXML is deprecated from lang3 onwards, use escapeXml10 instead for safety and compatibility of XML standards.
        
        xml = xml.concat("<" + attr.getID() + ">" + escXml + "</" + attr.getID() + ">");
        
        System.out.println(xml);
    }
}

class Attr {
    private String id;
    private String value;

    public Attr(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getID() {
        return id;
    }

    public String get() {
        return value;
    }
}