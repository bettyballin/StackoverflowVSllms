import java.lang.String;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutor {
    ExecutorService executor = Executors.newFixedThreadPool(10);
    Runnable task = () -> {
        // Your isolated task
    };
    {
        executor.execute(task);
    }

    public static void main(String[] args) {
    }
}