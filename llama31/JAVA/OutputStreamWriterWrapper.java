import java.io.OutputStreamWriter;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

public class OutputStreamWriterWrapper {
    private OutputStreamWriter bufferedWriter;

    public OutputStreamWriterWrapper() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bufferedWriter = new OutputStreamWriter(bos, StandardCharsets.ISO_8859_1);
    }

    public static void main(String[] args) {
        OutputStreamWriterWrapper wrapper = new OutputStreamWriterWrapper();
    }
}