import java.lang.String;
import oracle.xml.parser.v2.XSLProcessor;

public class OracleXDKExample {
    public static void main(String[] args) throws Exception {
        XSLProcessor processor = new XSLProcessor();
        processor.processXSL("transform.xsl", "input.xml", System.out);
    }
}