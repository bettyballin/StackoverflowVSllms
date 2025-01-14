import java.lang.String;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class RedirectSystemOutput {
    public static void main(String[] args) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        
        // Changing the System.out to a custom PrintStream
        System.setOut(ps);

        System.out.println("Hello, this will not go to console");

        // Resetting System.out back to standard output
        System.setOut(new PrintStream(System.out));

        System.out.println("Hello, this will go to console");
        
        // Output the captured data
        System.err.println(baos.toString());
    }
}