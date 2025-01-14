import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiCoreTaskRunner {

    public static void main(String[] args) {
        String filePath = "path_to_your_file"; // Path to the file containing tasks
        int numberOfCores = Runtime.getRuntime().availableProcessors();
        
        List<String> tasks = readTasksFromFile(filePath);
        
        ExecutorService executor = Executors.newFixedThreadPool(numberOfCores);

        for (String task : tasks) {
            final String currentTask = task;
            executor.execute(() -> processTask(currentTask));
        }

        // Shutdown the executor gracefully
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.MINUTES)) {
                executor.shutdownNow(); // Cancel currently executing tasks
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt(); // Preserve interrupt status
        }
    }

    private static List<String> readTasksFromFile(String filePath) {
        List<String> tasks = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                tasks.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    private static void processTask(String task) {
        // Call the main method or the processing logic here
        YourMainClass.main(new String[]{task});
    }
}

class YourMainClass {
    public static void main(String[] args) {
        // The previous main logic that processes each line goes here
        System.out.println("Processing: " + args[0]);
    }
}