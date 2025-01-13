import java.io.PrintStream;

public class Example_11_11 {
    public static void main(String[] args) {
        // Set up a new output stream
        PrintStream newOut = new PrintStream(System.err);

        // Update System.out to point to the new output stream
        System.setOut(newOut);

        // Print to the new output stream
        System.out.println("Hello, world!");
    }
}