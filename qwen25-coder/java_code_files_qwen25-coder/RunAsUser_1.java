import java.lang.String;
import java.io.*;

public class RunAsUser_1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] command = {"./run_as.sh", "cat", "/home/target_user/file.txt"};
        
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process = processBuilder.start();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        
        int exitCode = process.waitFor();
        System.out.println("Exited with code " + exitCode);
    }
}