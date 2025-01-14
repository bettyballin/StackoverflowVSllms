import java.lang.String;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class FrameSender {
    String frame = """
SEND
content-length:5

hello\0""";

    OutputStream outputStream = null;

    {
        outputStream.write(frame.getBytes(StandardCharsets.UTF_8));
    }

    public static void main(String[] args) {
    }
}