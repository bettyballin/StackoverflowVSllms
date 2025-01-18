import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

public class WriteXMLFile {
  public static void main(String[] args) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();

    // creating and adding elements to the xml tree.
    Document doc = builder.newDocument();
    Element rootElement = doc.createElement("company");
    doc.appendChild(rootElement);

    // create a comment and add it.
    Comment comment = doc.createComment("My Company Configuration File.");
    rootElement.appendChild(comment);

    writeXmlFile(doc, "target/test.xml");
  }

  private static void writeXmlFile(Document doc, String filename) throws Exception {
    // creating a transformer factory.
    TransformerFactory factory = TransformerFactory.newInstance();

    // create a new transformer.
    Transformer transformer = factory.newTransformer();

    // set the source for our xml file as the document we created.
    DOMSource source = new DOMSource(doc);

    // create a StringWriter to capture the XML output.
    StringWriter stringWriter = new StringWriter();
    StreamResult result = new StreamResult(stringWriter);

    // transforming our xml
    transformer.transform(source, result);

    Writer output = null;
    try {
      File file = new File(filename);
      if (!file.exists()) { // If the file doesn't exist, create it.
        file.createNewFile();
      } else { // If it exists, overwrite it.
        file.delete();
        file.createNewFile();
      }
      output = new BufferedWriter(new FileWriter(file));
      output.write(stringWriter.toString());
    } catch (IOException e) {
      throw new Exception("Exception while writing XML into file.", e);
    } finally {
      if (output != null) { // close the writer
        output.flush();
        output.close();
      }
    }
  }
}