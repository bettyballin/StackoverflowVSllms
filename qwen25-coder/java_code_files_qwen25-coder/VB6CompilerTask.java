import java.lang.String;
import java.lang.Runtime;
import java.lang.Process;

public class VB6CompilerTask {
    private Process vb6Process;

    public void execute() throws Exception {
        // Start the process
        vb6Process = Runtime.getRuntime().exec("VB6.exe yourParametersHere");

        // Add a shutdown hook to terminate the process if the JVM is shutting down
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (vb6Process != null && vb6Process.isAlive()) {
                System.out.println("Terminating VB6.exe...");
                vb6Process.destroy();
                try {
                    // Wait for the process to exit, but timeout after a certain period
                    boolean exited = vb6Process.waitFor(10, java.util.concurrent.TimeUnit.SECONDS);
                    if (!exited) {
                        vb6Process.destroyForcibly();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Restore interrupted status
                }
            }
        }));

        // Wait for the process to complete normally
        int exitCode = vb6Process.waitFor();
        System.out.println("VB6.exe exited with code " + exitCode);
    }

    public static void main(String[] args) {
        try {
            new VB6CompilerTask().execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}