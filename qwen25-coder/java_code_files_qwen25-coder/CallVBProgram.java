import java.lang.String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CallVBProgram {
    public static void main(String[] args) {
        // Specify the path to your VB application executable
        String vbAppPath = "C:\\path\\to\\your\\vbapp.exe";

        try {
            ProcessBuilder pb = new ProcessBuilder(vbAppPath);
            Process process = pb.start();

            // Optionally, read the output of the VB program
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("VB application exited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}