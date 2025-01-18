import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.StreamSupport;
import com.citytechinc.java.xmlbuilder.XmlBuilder;
// import org.apache.commons.io.IOUtils; // Not used in the code

public class XmlProcessor {
    public static void main(String[] args) {
        try (var inputStream = XmlProcessor.class.getResourceAsStream("/path/to/your/large-file.xml")) {
            AtomicInteger characterCounter = new AtomicInteger();
            StreamSupport.stream(
                new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8)
                ).lines().spliterator(), false)
                .limit(100) // Let's only process the first 100 lines of XML for simplicity
                .map(line -> {
                    var stringBuilder = new StringBuilder();
                    if (characterCounter.get() <= 25 * 1048576 - line.length()) { // Check if we exceed 25 MB
                        characterCounter.addAndGet(line.length());
                        stringBuilder.append("<pre>")
                            .append(XmlBuilder.create("root")
                                .keepDefaultNamespace(true)
                                .importFrom("./*")
                                .namespace("some-ns", "http://example.com/your-xml-schema") // Replace with your XML's namespace
                                .e(line).toString())
                            .append("</pre>");
                    } else {
                        stringBuilder.setLength(0);
                    }
                    return stringBuilder;
                })
                .filter(s -> s.length() > 0) // Ignore empty strings from the stream
                .forEach(System.out::print); // Output the processed XML
        } catch (Exception e) {
            throw e;
        }
    }
}