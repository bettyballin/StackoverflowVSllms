import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ProcessTerminator {
    public static void main(String[] args) {
        try {
            Process proc = Runtime.getRuntime().exec("cmd /c groovy BillingServer.groovy", null, new File("C:\\"));
            // Corrected the escape character in file path

            // To properly destroy a process and wait for it to finish execution, you should do something like this:
            try {
                Thread.sleep(100); // Allows some time for resources to get ready before killing them (Optional)
            } catch (InterruptedException e) {}

            proc.destroy();  // sends the SIGTERM signal which can be caught by system calls SIG_IGN or SIG_DFL in the process

            while (!proc.waitFor(1, TimeUnit.SECONDS)) { // Wait for some time to let the process finish gracefully
                try {
                    Thread.sleep(50); // (Optional) Allows some extra time between checks if needed
                } catch (InterruptedException e) {}
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}