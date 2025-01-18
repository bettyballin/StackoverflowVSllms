import java.lang.String;
import java.io.PrintStream;
import java.io.OutputStream;
import java.io.IOException;

public class ConsoleCapture extends PrintStream {
    private StringBuilder buffer;

    public ConsoleCapture() {
        super(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                System.out.write(b);
            }
        });
        this.buffer = new StringBuilder();
    }

    @Override
    public void println(String line) {
        System.out.println("Captured output: " + line);
        buffer.append(line).append("\n"); // Store each line for later inspection
    }

    public String getOutput() {
        return buffer.toString(); // Return captured output as a string
    }

    public static void main(String[] args) {
    }
}