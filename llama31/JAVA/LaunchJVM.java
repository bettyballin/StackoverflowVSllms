import java.io.FileWriter;
import java.io.IOException;

public class LaunchJVM {
    public static void main(String[] args) throws IOException {
        String[] command = {"java", "-jar", "your_server_jar.jar"};
        ProcessBuilder pb = new ProcessBuilder(command);
        pb.redirectErrorStream(true); // merge stdout and stderr
        pb.redirectOutput(ProcessBuilder.Redirect.appendTo(new FileWriter("output.log")));
        Process p = pb.start();
    }
}