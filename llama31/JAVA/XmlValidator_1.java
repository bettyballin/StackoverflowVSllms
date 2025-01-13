import java.io.IOException;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class XmlValidator_1_1 {
    public static boolean isValidDTD(String xmlFile) throws SAXException, IOException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        InputSource source = new InputSource(xmlFile);
        reader.parse(source);
        return reader.getFeature("http://xml.org/sax/features/validation");
    }

    public static boolean isValidXSD(String xmlFile, String xsdFile) throws SAXException, IOException {
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        Schema schema = factory.newSchema(new StreamSource(xsdFile));
        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(xmlFile));
        return true;
    }

    public static void main(String[] args) throws SAXException, IOException {
        String xmlFile = "example.xml";
        if (isValidDTD(xmlFile)) {
            System.out.println("Validates against DTD");
        } else if (isValidXSD(xmlFile, "example.xsd")) {
            System.out.println("Validates against XSD");
        } else {
            System.out.println("Does not validate against either DTD or XSD");
        }
    }
}