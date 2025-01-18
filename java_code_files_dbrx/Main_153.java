import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import org.apache.tika.detect.DefaultEncodingDetector;
import org.apache.tika.detect.EncodingDetector;
import org.apache.tika.metadata.Metadata;

public class Main_153 {
    public static void main(String[] args) throws Exception {
        EncodingDetector detector = new DefaultEncodingDetector();
        String sampleText = "your string here"; // replace with your own text or file input
        ByteArrayInputStream stream = new ByteArrayInputStream(sampleText.getBytes());
        Metadata metadata = new Metadata();
        Charset charset = detector.detect(stream, metadata);
        System.out.println("Charset: " + (charset != null ? charset.name() : "Unknown")); // prints the charset of the string or file input
    }
}