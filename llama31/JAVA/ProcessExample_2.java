import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProcessExample_2 {
    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("my_command");
        Process process = pb.start();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            try (BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = output.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (Exception e) {
                // Handle exception
            }
        });
    }
}