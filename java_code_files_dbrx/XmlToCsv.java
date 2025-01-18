import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XmlToCsv {
    public static void main(String[] args) throws IOException, TransformerException {
        Path sourceXml = Paths.get("source.xml"); // The path to the input XML file you want to transform.
        Path outputCsv = Paths.get("output.csv"); // The path to save the CSV result.

        try (InputStream stylesheet = XmlToCsv.class.getClassLoader()
                .getResourceAsStream("xml_to_csv.xslt")) { // Location of your xsl file, in this case it's on classpath.
            transformXml(sourceXml, outputCsv, new StreamSource(stylesheet));
        } catch (NullPointerException e) {
            System.err.println("Failed to load XSLT: " + e);
        }
    }

    public static void transformXml(Path sourceXml, Path csvOutputFile, Source xsltStylesheet)
            throws IOException, TransformerException {
        try (OutputStream outputStream = Files.newOutputStream(csvOutputFile)) {
            // Initialize TransformerFactory class
            TransformerFactory factory = new net.sf.saxon.TransformerFactoryImpl();
            Source xmlSource = new StreamSource(Files.newInputStream(sourceXml));

            /* Using Saxon XSLT processor */
            Templates templates = factory.newTemplates(xsltStylesheet);
            Transformer transformer = templates.newTransformer();

            // Configure outputStream for the transformation
            Result outputResult = new StreamResult(outputStream);

            // Initialize and perform transformation to produce desired CSV file format from XML input
             transformer.transform(xmlSource, outputResult);
        } catch (Exception e) {
            System.err.println("Failed during transformation: " + e);
        }
    }
}