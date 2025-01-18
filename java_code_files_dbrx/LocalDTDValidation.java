import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import org.w3c.dom.Document;
import org.w3c.dom.ls.*;
import org.xml.sax.SAXException;

public class LocalDTDValidation {
    public static void main(String[] args) throws Exception {
        File xmlFile = new File("yourFile.xml");
        final InputStream dtdInputStream = new FileInputStream("local.dtd");

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        // This will disable XML validation, including DTD parsing and validation so there won't be any conflict with the file DTD:
        dbFactory.setNamespaceAware(true); // Needed for SchemaFactory below to not throw a NullPointerException on some JDKs; this is safe as long as no namespace support in our documents!
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);

        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema"); // Use XML Schema instead of DTD since that's what javax.xml.validation uses (unfortunately), but it will work for your purpose with a little trickery below:
        factory.setResourceResolver(new LSResourceResolver() { // We use SchemaFactory to validate against our DTD, and this is the way to force it to do that even when it doesn't want!
            @Override
            public LSInput resolveResource(String type, String namespaceURI, String publicId, String systemId, String baseURI) {
                return new LSInput() {
                    @Override
                    public Reader getCharacterStream() {
                        return null;
                    }
                    @Override
                    public void setCharacterStream(Reader characterStream) {
                    }
                    @Override
                    public InputStream getByteStream() {
                        return dtdInputStream;
                    }
                    @Override
                    public void setByteStream(InputStream byteStream) {
                    }
                    @Override
                    public String getStringData() {
                        return null;
                    }
                    @Override
                    public void setStringData(String stringData) {
                    }
                    @Override
                    public String getSystemId() {
                        return systemId;
                    }
                    @Override
                    public void setSystemId(String systemId) {
                    }
                    @Override
                    public String getPublicId() {
                        return publicId;
                    }
                    @Override
                    public void setPublicId(String publicId) {
                    }
                    @Override
                    public String getBaseURI() {
                        return baseURI;
                    }
                    @Override
                    public void setBaseURI(String baseURI) {
                    }
                    @Override
                    public String getEncoding() {
                        return null;
                    }
                    @Override
                    public void setEncoding(String encoding) {
                    }
                    @Override
                    public boolean getCertifiedText() {
                        return false;
                    }
                    @Override
                    public void setCertifiedText(boolean certifiedText) {
                    }
                };
            }
        });

        Schema schema = factory.newSchema();
        Validator validator = schema.newValidator();
        try {
            validator.validate(new javax.xml.transform.dom.DOMSource(doc));   // Validate your XML file against the DTD now!
        } catch (SAXException se) {
            System.out.println("Document is invalid according to DTD: " + se.getMessage());
        } finally {
            dtdInputStream.close(); // Don't forget this in production-quality code!
        }
    }
}