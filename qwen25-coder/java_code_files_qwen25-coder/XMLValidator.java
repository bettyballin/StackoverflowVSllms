import java.lang.String;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class XMLValidator {
    public static void main(String[] args) throws Exception {
        String xmlFilePath = "yourfile.xml";
        String xsdFilePath = "yourschema.xsd";

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        File schemaFile = new File(xsdFilePath);

        // Compile the XSD.
        Schema schema = schemaFactory.newSchema(schemaFile);

        // Parse and validate the XML file.
        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(new File(xmlFilePath)));
        
        System.out.println("Your XML is valid against your XSD!");
    }
}