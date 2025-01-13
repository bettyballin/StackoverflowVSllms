import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.xalan.xsltc.trax.TransformerFactoryImpl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XmlTransformer {
    public static void main(String[] args) throws Exception {
        XmlTransformer transformer = new XmlTransformer();
        transformer.transformXml("type", "doc_id");
    }

    public void transformXml(String type, String docId) throws Exception {
        // Create a TransformerFactory instance
        TransformerFactory factory = new TransformerFactoryImpl();

        // Create a Transformer instance
        Transformer transformer = factory.newTransformer(new StreamSource(new File("xsl/" + type + ".xsl")));

        // Set the input XML
        Source xmlSource = new StreamSource(new File("xml/" + docId + ".xml"));

        // Set the output to a file
        File outputFile = new File("output.html");
        StreamResult result = new StreamResult(new FileWriter(outputFile));

        // Transform the XML
        transformer.transform(xmlSource, result);

        System.out.println("Transformation complete. Output written to " + outputFile.getAbsolutePath());
    }
}