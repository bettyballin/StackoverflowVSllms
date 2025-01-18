import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.dom.DOMSource;

import javax.xml.XMLConstants;

import java.io.IOException;

public class XMLValidator {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFac = DocumentBuilderFactory.newInstance();
            dbFac.setNamespaceAware(true); // Add this line
            DocumentBuilder db = dbFac.newDocumentBuilder();
            Document xmlDoc = db.parse("<your XML file here>");

            SchemaFactory schemaFact = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Source schemaFile = new StreamSource("/path/to/the/schema.xsd");
            Schema schema = schemaFact.newSchema(schemaFile);

            Validator validator = schema.newValidator();
            Source xmlSource = new DOMSource(xmlDoc);

            validator.validate(xmlSource);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}