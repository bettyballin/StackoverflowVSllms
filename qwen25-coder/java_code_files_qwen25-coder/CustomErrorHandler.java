import java.lang.String;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class CustomErrorHandler implements ErrorHandler {

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        // Log or ignore warnings if needed.
        System.out.println("Warning: " + exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        String message = exception.getMessage();
        // Ignore errors related to missing IDs for IDREF attributes
        if (!message.contains("IDREF")) {
            throw exception;
        }
        System.out.println("Ignored Error: " + message);
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        String message = exception.getMessage();
        // Ignore fatal errors related to missing IDs for IDREF attributes
        if (!message.contains("IDREF")) {
            throw exception;
        }
        System.out.println("Ignored Fatal Error: " + message);
    }

	public static void main(String[] args) {
	}
}