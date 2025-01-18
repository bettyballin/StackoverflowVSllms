import java.lang.String;
import java.io.StringWriter;
import java.io.PrintWriter;

public class ExceptionLogger {
    static {
        try {
            // Some code that may throw exceptions...
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);

            // Write the stack trace to your log file or system console output:
            System.out.println("Caught Exception: " + sw.toString());
        }
    }

    public static void main(String[] args) {
    }
}