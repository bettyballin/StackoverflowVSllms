import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_449 {
    public static void main(String[] args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "netstat -aon | find \"8080\"");
        Process process = processBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}