/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.IOException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XmlValidator_4 {
    public static void main(String[] stringArray) {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            Schema schema = schemaFactory.newSchema(new File("path/to/your/schema.xsd"));
            Validator validator = schema.newValidator();
            ErrorHandler errorHandler = new ErrorHandler(){

                @Override
                public void warning(SAXParseException sAXParseException) throws SAXException {
                }

                @Override
                public void fatalError(SAXParseException sAXParseException) throws SAXException {
                }

                @Override
                public void error(SAXParseException sAXParseException) throws SAXException {
                    System.out.println("Validation error at line " + sAXParseException.getLineNumber() + ", column " + sAXParseException.getColumnNumber() + ": " + sAXParseException.getMessage());
                }
            };
            validator.setErrorHandler(errorHandler);
            StreamSource streamSource = new StreamSource(new File("path/to/your/xml.xml"));
            validator.validate(streamSource);
        }
        catch (IOException | SAXException exception) {
            System.out.println("Error validating XML: " + exception.getMessage());
        }
    }
}
