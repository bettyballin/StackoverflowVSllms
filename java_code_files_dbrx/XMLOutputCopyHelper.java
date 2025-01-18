import java.lang.String;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLOutputFactory;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.stream.XMLStreamException;

public class XMLOutputCopyHelper {
    XMLEventReader reader;
    XMLOutputFactory outputFactory;
    XMLStreamWriter writer;

    public XMLOutputCopyHelper(InputStream bis, OutputStream your_output_stream) throws XMLStreamException {
        reader = XMLInputFactory.newInstance().createXMLEventReader(bis); // This is our input stream created from the cipher
        outputFactory = XMLOutputFactory.newInstance();
        writer = outputFactory.createXMLStreamWriter(your_output_stream);
        // Now copy events between reader and writer here, i.e., writeStartDocument(), etc.
    }

    public static void main(String[] args) {
    }
}