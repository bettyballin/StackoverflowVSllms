import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorld_15 {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);
        
        // Using write()
        try {
            out.write("Hello, World!\n");
        } catch (IOException e) {
            System.err.println("Error writing to output stream: " + e.getMessage());
        }

        // Using print()
        out.print("Hello, World!\n"); // Does not throw IOException
        out.close(); // Good practice to close the PrintWriter
    }
}