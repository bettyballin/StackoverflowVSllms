import java.lang.String;
import java.util.Scanner;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.IOException;
import java.util.concurrent.*;

public class CallableRunner<T> {

    public static void main(String[] args) throws Exception {
        Callable<String> callable = () -> {
            try (Scanner scanner = new Scanner(System.in)) { // Read from standard input
                StringBuilder result = new StringBuilder();
                while (scanner.hasNextLine()) {
                    result.append(scanner.nextLine()).append("\n");
                }
                System.out.println("Processed: " + result.toString()); // Write to standard output
                return result.toString();
            }
        };

        CallableRunner<String> runner = new CallableRunner<>();
        runner.executeCallableWithIO(callable, "Input data\nMore input");
    }

    public void executeCallableWithIO(Callable<T> callable, String inputData) throws Exception {
        PipedInputStream processOutput = new PipedInputStream();
        PipedOutputStream processInput = new PipedOutputStream(processOutput);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        final Future<T> future = executor.submit(() -> {
            System.setIn(processOutput); // Redirect input stream
            return callable.call();
        });

        // Simulate sending data to the Callable's stdin
        new Thread(() -> {
            try (PipedOutputStream os = processInput) {
                os.write(inputData.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

        T result = future.get(); // Wait for completion and get the result

        System.out.println("Callable returned: " + result);

        // Shutdown executor
        executor.shutdown();
    }
}