import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class CommandLineRunner {

    public static void runCommandlineMain(String classPathFile, String args[]) throws Exception {
        URL[] urls = getJarUrls(classPathFile);
        URLClassLoader classLoader = new URLClassLoader(urls);

        Class<?> clazz = classLoader.loadClass("liquibase.commandline.Main");
        Method main = clazz.getMethod("main", String[].class);

        // Redirect output to a custom PrintStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        System.setErr(printStream);

        main.invoke(null, new Object[]{args});

        // Get the output
        String output = outputStream.toString();

        // Reset the output streams
        System.setOut(System.out);
        System.setErr(System.err);

        // Print the output
        System.out.println(output);
    }

    public static URL[] getJarUrls(String classPathFile) {
        // This method is not implemented in your original code.
        // You need to implement it to get the jar URLs from the classPathFile.
        // For example:
        return new URL[]{new URL("file://path/to/your/jarfile.jar")};
    }

    public static void main(String[] args) {
    }
}