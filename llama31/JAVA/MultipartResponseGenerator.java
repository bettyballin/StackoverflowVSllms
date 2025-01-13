import java.io.PrintStream;

public class MultipartResponseGenerator {
    public static void main(String[] args) {
        // Simulate the response output
        PrintStream out = System.out;

        // Set the response content type to multipart/mixed
        System.out.println("Content-Type: multipart/mixed; boundary=END_OF_FILE");

        // Output the XML data
        out.println("<?xml version='1.0' encoding='UTF-8'?>");
        out.println("<graph_data>");
        // ... output the XML data ...
        out.println("</graph_data>");

        // Output the boundary
        out.println("--END_OF_FILE");

        // Output the image data
        out.println("Content-Type: image/png");
        out.println("Content-Disposition: inline; filename=graph.png");
        // ... output the image data ...

        // Output the final boundary
        out.println("--END_OF_FILE--");
    }
}