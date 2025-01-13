import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HtmlWriter {
    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileWriter("output.html"))) {
            out.write("<div class=\"bar\">");
            // ...
            out.write("</div>");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}