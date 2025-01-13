import java.lang.String;
import java.io.File;
import java.io.IOException;

public class XSD2XML {
    public static void main(String[] args) throws IOException {
        String xsdFile = "your_schema.xsd";
        String xmlFile = "your_schema.xml";

        ProcessBuilder pb = new ProcessBuilder("xsd.exe", "/c", "/nologo", xsdFile);
        pb.redirectOutput(new File(xmlFile));
        pb.start();
    }
}