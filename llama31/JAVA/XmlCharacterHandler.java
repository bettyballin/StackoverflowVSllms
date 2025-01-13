import java.lang.String;

public class XmlCharacterHandler {
    public static void main(String[] args) {
        XmlCharacterHandler handler = new XmlCharacterHandler();
        String chars = "your_string_here"; // replace with your desired string
        handler.process(chars);
    }

    public void process(String chars) {
        XmlHandler xmlHandler = new XmlHandler(); // assuming XmlHandler is a valid class
        xmlHandler.startCDATA();
        xmlHandler.characters(chars.toCharArray(), 0, chars.length());
        xmlHandler.endCDATA();
    }
}

// Assuming XmlHandler is a valid class, you would need to define it or import it
class XmlHandler {
    public void startCDATA() {
        System.out.println("<![CDATA[");
    }

    public void characters(char[] chars, int start, int length) {
        System.out.println(String.valueOf(chars, start, length));
    }

    public void endCDATA() {
        System.out.println("]]>");
    }
}