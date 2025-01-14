import java.lang.String;
import java.io.IOException;
import java.io.OutputStream;
import java.io.File;

public class UnblockProcess {
    public static void main(String[] args) {
        String cmd = "your_command x";
        String cmdDir = "/path/to/command/directory";

        try {
            Process p = Runtime.getRuntime().exec(cmd, null, new File(cmdDir));
            
            // Write input to the process
            OutputStream os = p.getOutputStream();
            os.write("
".getBytes()); // This simulates pressing "Enter"
            os.flush();

            int exitCode = p.waitFor();  // Wait for the process to finish

            System.out.println("Process exited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}