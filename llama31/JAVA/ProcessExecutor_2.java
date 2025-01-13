import java.lang.ProcessBuilder;
import java.lang.Process;

public class ProcessExecutor_2_2 {
    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("<childProcessName>");
        pb.inheritIO(); // inherit input/output streams
        Process process = pb.start();

        // ...

        // Make sure the child process is destroyed when the parent process exits
        process.destroyForcibly();
    }
}