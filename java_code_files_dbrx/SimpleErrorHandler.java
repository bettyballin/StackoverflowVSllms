import java.lang.String;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.SAXException;

public class SimpleErrorHandler {
    class SimpleErrorHandler implements ErrorHandler {
        public void warning(SAXParseException e) throws SAXException {}
        public void error(SAXParseException e) throws SAXException {}
        public void fatalError(SAXParseException e) throws SAXException {}
    }
    public static void main(String[] args) {
    }
}