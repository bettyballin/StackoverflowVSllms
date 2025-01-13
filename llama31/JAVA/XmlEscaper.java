import org.apache.commons.lang.StringEscapeUtils;

public class XmlEscaper {
    public static void main(String[] args) {
        // You need to define 'attr' or pass it as a parameter to escapeXml method
        // For demonstration purposes, let's assume 'attr' is a string variable
        String attr = "Some XML content";
        String escXml = StringEscapeUtils.escapeXml(attr);
        System.out.println(escXml);
    }
}