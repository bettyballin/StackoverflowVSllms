import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.PipedReader;
import java.io.OutputStream;
import java.io.PrintStream;

public class MyClass {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("somecommand");
        pb.redirectErrorStream(true); // to mix stdout and stderr from the command
        InputStreamReader r = null;
        OutputStreamWriter w = null;
        try {
            final Process process = pb.start();
            // Input and Output streams with the process,
            // wrapped by reader/writer to be able to operate in text mode instead of bytes:
            r = new InputStreamReader(process.getInputStream());
            w = new OutputStreamWriter(process.getOutputStream());
            // Same thing, but for System.in and System.out:
            final PipedWriter pw2 = new PipedWriter();
            final PipedReader pr2 = new PipedReader(pw2);
            OutputStream os = new OutputStream() {
                @Override
                public void write(int b) throws IOException {
                    pw2.write(b);
                }

                public void write(byte[] b) throws IOException {
                    String s = new String(b);
                    pw2.write(s);
                }

                public void write(byte[] b, int off, int len) throws IOException {
                    String s = new String(b, off, len);
                    pw2.write(s);
                }
            };
            System.setOut(new PrintStream(os));
            // some thread to read from 'r' and write into 'w'
            // Thread loop omitted
        } catch (IOException ex) {
            // handle exception
        } finally {
            try { 
                if (r != null) r.close(); 
                if (w != null) w.close(); 
            } catch(Exception e) {
                // handle exception
            }
        }
    }
}