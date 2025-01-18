import java.io.*;
import java.lang.ProcessBuilder.Redirect;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ProcessCallableExecutor {

    public <T> void runCallableInProcess(Callable<T> callable) {
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "path/to/your/CallableRunnerClass");
            pb.redirectInput(Redirect.PIPE);
            pb.redirectOutput(Redirect.PIPE);

            Process process = pb.start();

            try (ObjectOutputStream outputToProcess = new ObjectOutputStream(process.getOutputStream());
                 ObjectInputStream inputFromProcess = new ObjectInputStream(process.getInputStream())) {

                // Send callable to process
                outputToProcess.writeObject(callable);
                outputToProcess.flush();

                // Wait for process to complete
                if (process.waitFor(5, TimeUnit.SECONDS)) {
                    @SuppressWarnings("unchecked")
                    T result = (T) inputFromProcess.readObject();
                    System.out.println("Result: " + result);
                } else {
                    throw new RuntimeException("Execution timed out.");
                }
            } catch (IOException | InterruptedException | ClassNotFoundException ex) {
                ex.printStackTrace();
            } finally {
                process.destroy();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) {
    }
}