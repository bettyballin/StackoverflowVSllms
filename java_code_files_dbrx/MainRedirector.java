import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;

public class MainRedirector {
    public void runCommandlineMain(Class<?> clazz, String[] args) {
        PrintStream savedOut = System.out; // Save current standard output stream so it can be restored later.
        try {
            ConsoleCapture console = new ConsoleCapture(); // Create a captured output
            System.setOut(console); // Redirect standard output to the capture instance
            Method main = clazz.getMethod("main", String[].class);
            main.invoke(null, new Object[]{args}); // Run target application's 'main'. Output will be redirected now.
            System.out.println("Captured Output: " + console.getOutput()); // Display captured data after app execution finishes.
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            System.setOut(savedOut); // Restore normal standard out behavior once done with the custom capture class.
        }
    }
    public static void main(String[] args) {
        MainRedirector mr = new MainRedirector();
        mr.runCommandlineMain(MainRedirector.class, args);
    }
}

class ConsoleCapture extends PrintStream {
    private ByteArrayOutputStream outputStream;

    public ConsoleCapture() {
        super(new ByteArrayOutputStream());
        outputStream = (ByteArrayOutputStream) this.out;
    }

    public String getOutput() {
        return outputStream.toString();
    }
}