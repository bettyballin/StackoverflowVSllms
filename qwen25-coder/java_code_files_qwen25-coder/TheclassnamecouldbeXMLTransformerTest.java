import java.lang.String;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;

public class TheclassnamecouldbeXMLTransformerTest {

    public static void main(String[] args) {
        String testChunk1 = "<e1>text</e1>";
        String testChunk2 = "<dummy>" + testChunk1 + "</dummy>";
        String testChunk3 = "<dummy>" + "<e1>text</e1><e2>text</e2>" + "</dummy>";
    
        try {
            StringReader sr = new StringReader(testChunk3);
            StringWriter sw = new StringWriter();
        
            TransformerFactory.newInstance().newTransformer().transform(
                new StreamSource(sr), new StreamResult(sw));
        
            System.out.println(sw.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}