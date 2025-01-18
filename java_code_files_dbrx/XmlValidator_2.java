import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;

import org.w3c.dom.ls.LSResourceResolver;
import org.w3c.dom.ls.LSInput;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import java.io.*;
import java.io.StringReader;

public class XmlValidator {
    private static String xml = "<root><element value=\"Hello World\"/></root>";
    public static String xsd = "<xs:schema xmlns:xs='http://www.w3.org/2001/XMLSchema'>" +
            "  <xs:element name='root'>" +
            "      <xs:complexType>" +
            "          <xs:sequence maxOccurs=\"unbounded\">" +
            "              <xs:element name='element' type='emptyElementType' />" +
            "         </xs:sequence>" +
            "     </xs:complexType>" +
            "  </xs:element>" +
            "<xs:simpleType name=\"emptyElementType\">" +
            " <xs:restriction base=\"xs:string\">" +
            "<xs:pattern value=\"(.*?)\"/></xs:restriction>" +
            " </xs:simpleType>" +
            "</xs:schema>";

    public static void main(String... args) throws Exception {
        // Create the schema factory:
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        // Load the XML and XSD resources first as Source objects for later use:
        Source xmlSource = new StreamSource(new StringReader(xml));
        Source xsdSource = new StreamSource(new StringReader(xsd));

        // Create a resource resolver
        final LSResourceResolver resourceResolver = new LocalXmlSchema();
        sf.setResourceResolver(resourceResolver);

        // Create a schema
        Schema schema = sf.newSchema(xsdSource);

        // Create a validator object using the schema:
        Validator validator = schema.newValidator();

        // Try to validate:
        try {
            validator.validate(xmlSource);
            System.out.println("Valid XML.");
        } catch (SAXParseException e) {
            System.err.printf("%s is not valid.\n", xml);
            System.err.printf("Reason: %s\n", e.getLocalizedMessage());
        } catch (Exception ex) {
            System.out.println("A general validation error occurred");
        }
    }

    static class LSInputImpl implements LSInput {

        private String publicId;
        private String systemId;
        private String baseURI;
        private String data;
        private Reader characterStream;
        private InputStream byteStream;
        private String encoding;
        private boolean certifiedText;

        @Override
        public Reader getCharacterStream() {
            if (characterStream == null && data != null)
                characterStream = new StringReader(data);
            return characterStream;
        }

        @Override
        public void setCharacterStream(Reader characterStream) {
            this.characterStream = characterStream;
        }

        @Override
        public InputStream getByteStream() {
            return byteStream;
        }

        @Override
        public void setByteStream(InputStream byteStream) {
            this.byteStream = byteStream;
        }

        @Override
        public String getStringData() {
            return data;
        }

        @Override
        public void setStringData(String data) {
            this.data = data;
        }

        @Override
        public String getSystemId() {
            return systemId;
        }

        @Override
        public void setSystemId(String systemId) {
            this.systemId = systemId;
        }

        @Override
        public String getPublicId() {
            return publicId;
        }

        @Override
        public void setPublicId(String publicId) {
            this.publicId = publicId;
        }

        @Override
        public String getBaseURI() {
            return baseURI;
        }

        @Override
        public void setBaseURI(String baseURI) {
            this.baseURI = baseURI;
        }

        @Override
        public String getEncoding() {
            return encoding;
        }

        @Override
        public void setEncoding(String encoding) {
            this.encoding = encoding;
        }

        @Override
        public boolean getCertifiedText() {
            return certifiedText;
        }

        @Override
        public void setCertifiedText(boolean certifiedText) {
            this.certifiedText = certifiedText;
        }
    }

    static class LocalXmlSchema implements LSResourceResolver {

        @Override
        public LSInput resolveResource(String type, String namespaceURI, String publicId, String systemId, String baseURI) {
            LSInputImpl lsInput = new LSInputImpl();
            if ("XSD_NAME".equals(publicId)) {
                lsInput.setPublicId(publicId);
                lsInput.setStringData(XmlValidator.xsd);
            }
            // Handle other cases or throw an exception if necessary
            return lsInput;
        }
    }

}