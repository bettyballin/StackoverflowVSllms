import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class EnvironmentVariableSetter {
    public static void main(String[] args) throws Exception {
        List<String> command = Arrays.asList("java", "-jar", "your-application.jar"); // replace with your real application and arguments
        ProcessBuilder pb = new ProcessBuilder()
            .command(command); // sets the command, but does not execute it yet!
        Map<String, String> environment = pb.environment(); // get a map of system environment variables from process builder instance
        environment.put("SOMEENVVAR", "value1"); // add or redefine any environment variable value here!
        Process proc = pb.start();
    }
}