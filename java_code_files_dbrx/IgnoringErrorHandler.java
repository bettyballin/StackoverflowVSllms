import org.apache.xerces.parsers.SAXParser;
import org.xml.sax.*;
import java.io.IOException;

public class IgnoringErrorHandler implements ErrorHandler {
    private boolean hasErrors = false;

    // Implement this method to ignore any warnings that are typically reported by SAX parser.
    @Override
    public void warning(SAXParseException exception) throws SAXException {
        //System.out.println("Warning: " + exception);
    }

    // Override the error method and mark a flag noting at least one error was found
    @Override
    public void error(SAXParseException e) throws SAXException {
         hasErrors = true;
         System.out.println("Warning: " + e);
    }

    // Override the fatalError method and throw a runtime exception to fail the build
    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        hasErrors = true; // mark this because we don't want to continue processing after a parser error
        if (e.getMessage().contains("The content of element type")){
          System.out.println("Warning: " + e);
        } else {
            throw new RuntimeException(e);
        }
    }

    // You can check if there were any such non-fatal errors found, after parser finishes processing the XML document
    public boolean hasErrors() {
      return this.hasErrors;
    }
}