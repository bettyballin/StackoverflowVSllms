import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class RunAsUser {
    public static void main(String[] args) {
        String userName = "jim";
        String password = "jim's password";
        String command = "ls ~bob";

        ProcessBuilder pb = new ProcessBuilder("su", "-c", command, userName);
        pb.redirectErrorStream(true);

        try {
            Process p = pb.start();
            OutputStream os = p.getOutputStream();
            os.write((password + "\n").getBytes());
            os.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            p.waitFor();
        } catch (IOException e) {
            System.err.println("Error executing command: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Error waiting for process to finish: " + e.getMessage());
        }
    }
}