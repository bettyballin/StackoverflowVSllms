public class MyClass {
    public static void main(String[] args) {
        // Create an instance of Attr with an ID and value
        Attr attr = new Attr("attributeID", "Sample value & with special characters < > &");

        // Initialize the XML string
        String xml = "";

        // Escape XML special characters in the attribute value
        String escXml = escapeXml(attr.get());

        // Concatenate the escaped value into an XML element
        xml = xml.concat("<" + attr.getID() + ">" + escXml + "</" + attr.getID() + ">");

        // Output the resulting XML
        System.out.println(xml);
    }

    // Method to escape XML special characters
    public static String escapeXml(String input) {
        if (input == null) {
            return null;
        }
        StringBuilder escaped = new StringBuilder();
        for (char c : input.toCharArray()) {
            switch (c) {
                case '&':
                    escaped.append("&amp;");
                    break;
                case '<':
                    escaped.append("&lt;");
                    break;
                case '>':
                    escaped.append("&gt;");
                    break;
                case '"':
                    escaped.append("&quot;");
                    break;
                case '\'':
                    escaped.append("&apos;");
                    break;
                default:
                    escaped.append(c);
                    break;
            }
        }
        return escaped.toString();
    }
}

// Class representing an attribute with an ID and value
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