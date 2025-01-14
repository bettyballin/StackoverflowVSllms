import java.lang.String;
import java.io.IOException;

public class ChildProcessLauncher {
    public static void main(String[] args) {
        try {
            // Using sh with -c and 'setsid' to start a new session for the child process
            final String[] cmd = {"/bin/sh", "-c", "setsid <childProcessName>"};
            Process process = Runtime.getRuntime().exec(cmd);

            // Optionally, you can manage the lifecycle of the process using addShutdownHook
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                System.out.println("Shutting down child process...");
                process.destroy();
            }));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}