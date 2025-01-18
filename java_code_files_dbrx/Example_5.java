/*Example Java Implementation using DOM Parser for XML*/
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
public class Example_5 {
  public static void main(String[] args) throws Exception{
    String dbData = "<data><name>John</name></data>"; //sample data from DB as XML string representation
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = null;
    try {
      ByteArrayInputStream input  = new ByteArrayInputStream(dbData.getBytes());
      Document xmlDoc=builder.parse(input); //Parse input XML string into an Object Document
      /*Implement transformational logic according to requirement and generate externalXML*/
    } catch (Exception e) {e.printStackTrace();}
}}