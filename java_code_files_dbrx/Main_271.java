import jakarta.xml.stream.XMLStreamWriter;
import jakarta.xml.stream.XMLOutputFactory;
import java.io.ByteArrayOutputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        // Create a ByteArrayOutputStream to capture the output
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter pw = factory.createXMLStreamWriter(bos, "UTF-8");

        pw.writeStartDocument();
        //... write your large XML content
        pw.writeStartElement("root");
        pw.writeCharacters("Sample content");
        pw.writeEndElement();
        pw.writeEndDocument();

        pw.flush();

        // Retrieve the output stream from the writer
        // Since XMLStreamWriter doesn't have getProperty, we use 'bos' directly
        // ByteArrayOutputStream bos = (ByteArrayOutputStream) pw.getProperty("outputstream");
        byte[] unencryptedBytes = bos.toByteArray();
    }
}