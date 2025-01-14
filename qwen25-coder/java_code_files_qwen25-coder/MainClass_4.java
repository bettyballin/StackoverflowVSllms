import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) throws IOException, InterruptedException {
        startSecondJVM();
    }

    public static void startSecondJVM() throws IOException, InterruptedException {
        List<String> command = new ArrayList<>();
        // Use Paths.get for better platform independence
        String javaBinary = Paths.get(System.getProperty("java.home"), "bin", "java").toString();
        command.add(javaBinary);

        // Add JVM arguments (copying from the current JVM)
        command.addAll(List.of(
            "-cp",
            System.getProperty("java.class.path")
            // You can add other system properties and JVM options here using -D or -X
        ));

        // Add main class name of the second JVM program
        command.add(AnotherClassWithMainMethod.class.getName());

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        // Optional: Redirect error and output streams to avoid deadlocks
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();

        // Optionally read from the process's input stream here to handle output

        int exitCode = process.waitFor();
        System.out.println("Second JVM exited with code " + exitCode);
    }
}

class AnotherClassWithMainMethod {
    public static void main(String[] args) {
        System.out.println("Hello from AnotherClassWithMainMethod!");
    }
}