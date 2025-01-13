import java.io.IOException;

public class Main_56 {
    public static void main(String[] args) {
        String[] command = {
            "java",
            "-agentpath:/path/to/jprofiler/lib/jprofiler.jar",
            "-jar",
            "/path/to/tomcat/bin/bootstrap.jar"
        };

        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}