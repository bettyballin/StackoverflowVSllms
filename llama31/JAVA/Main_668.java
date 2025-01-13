import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main_668 {
    public static void main(String[] args) throws Exception {
        // Set the Xalan implementation
        System.setProperty("javax.xml.transform.TransformerFactory", "org.apache.xalan.processor.TransformerFactoryImpl");

        // Create a TransformerFactory instance
        TransformerFactory factory = TransformerFactory.newInstance();

        // Define the input and output streams
        FileInputStream xslInputStream = new FileInputStream("transform.xsl");
        FileInputStream xmlInputStream = new FileInputStream("input.xml");
        FileOutputStream outputStream = new FileOutputStream("output.xml");

        // Create a Transformer instance
        Transformer transformer = factory.newTransformer(new StreamSource(xslInputStream));

        // Transform your XML document
        transformer.transform(new StreamSource(xmlInputStream), new StreamResult(outputStream));

        // Close the streams
        xslInputStream.close();
        xmlInputStream.close();
        outputStream.close();
    }
}