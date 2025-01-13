import java.lang.String;
import java.lang.ProcessHandle;
import java.lang.ProcessBuilder;

public class ParentProcess {
    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("your_child_process_command");
        Process p = pb.start();

        // Get the process handle of the child process
        ProcessHandle childHandle = ProcessHandle.of(p.pid()).orElseThrow();

        // Add a shutdown hook to terminate the child process when the parent exits
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            childHandle.destroy();
        }));
    }
}