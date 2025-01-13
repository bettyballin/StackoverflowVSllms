import java.util.concurrent.CompletableFuture;

public class LongRunningTasks_1_1 {
    public CompletableFuture<Void> asyncTask(int iterations) {
        return CompletableFuture.runAsync(() -> {
            for (int i = 0; i < iterations; i++) {
                // Perform some CPU-intensive calculations
                double result = Math.pow(Math.PI, 1000);
            }
        });
    }

	public static void main(String[] args) {
        LongRunningTasks_1 longRunningTasks = new LongRunningTasks_1();
        longRunningTasks.asyncTask(1000);
	}
}