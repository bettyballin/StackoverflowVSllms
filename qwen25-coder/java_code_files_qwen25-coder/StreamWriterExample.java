import java.lang.String;
import java.io.PrintStream;
import java.io.PrintWriter;

public class StreamWriterExample {
    public static void main(String[] args) {
        // Example with PrintStream
        PrintStream ps = System.err; // Typically stderr, which is less likely to fail
        try {
            ps.println("This message might go to the error stream");
            if (ps.checkError()) {  // Check for errors after writing
                System.out.println("There was an error in writing to the print stream.");
            }
        } finally {
            ps.close();
        }

        // Example with PrintWriter
        PrintWriter pw = new PrintWriter(System.err, true);
        try {
            pw.println("This message might go to the error stream as well");
            if (pw.checkError()) {  // Check for errors after writing
                System.out.println("There was an error in writing to the print writer.");
            }
        } finally {
            pw.close();
        }
    }
}