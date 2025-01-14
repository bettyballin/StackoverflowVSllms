import java.lang.String;
import java.io.PrintWriter;

public class MyClass_41 {
    public void writeToResponse(PrintWriter writer) {
        // Write to the output stream directly using the provided PrintWriter
        writer.append("test1");
        writer.println("test2");
        writer.write("test3");
    }

    public static void main(String[] args) {
    }
}