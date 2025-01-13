import java.lang.String;
// JavaBenchmark.java
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class JavaBenchmark {
    @Param({"small.xml", "large.xml"})
    private String xmlFile;

    @Benchmark
    public void testXmlParser() {
        // Call the Java library
        java_xml_parser_parse(xmlFile);
    }

    // Define the native method
    public native void java_xml_parser_parse(String xmlFile);

    // Load the shared library
    static {
        System.loadLibrary("java_xml_parser");
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}