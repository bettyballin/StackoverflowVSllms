import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

public class MyCapturingWriter extends ServletOutputStream {
    private ByteArrayOutputStream baos;
    private PrintWriter writer;

    public MyCapturingWriter(String encoding) throws IOException {
        baos = new ByteArrayOutputStream();
        writer = new PrintWriter(new OutputStreamWriter(baos, encoding), true);
    }

    // Implement the write method to append bytes to internal buffer (baos in this case)
    @Override
    public void write(int b) throws IOException {
        baos.write(b);
    }

    // Other methods as per interface specification...
    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {
        // Implementation goes here if needed
    }

    public static void main(String[] args) {
        // Test the MyCapturingWriter class if necessary
    }
}