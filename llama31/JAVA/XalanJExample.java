import java.lang.String;
import org.apache.xalan.transformer.TransformerImpl;
import java.io.File;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;

public class XalanJExample {
    public static void main(String[] args) throws Exception {
        TransformerImpl transformer = new TransformerImpl(new StreamSource(new File("transform.xsl")));
        transformer.transform(new StreamSource(new File("input.xml")), new StreamResult(System.out));
    }
}