import javax.swing.*;
import java.util.concurrent.*;

public class MultithreadedUI {

    private final ExecutorService executor;
    private final JFrame frame;

    public MultithreadedUI() {
        this.frame = new JFrame("Multithreaded UI Example");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public void updateUI(Runnable task) {
        // SwingUtilities.invokeLater ensures that the task is executed on the Event Dispatch Thread
        SwingUtilities.invokeLater(task);
    }

    public <V> CompletableFuture<V> executeTask(Callable<V> task) {
        CompletableFuture<V> future = new CompletableFuture<>();
        executor.submit(() -> {
            try {
                V value = task.call();
                future.complete(value);
            } catch (Exception ex) {
                future.completeExceptionally(ex);
            }
        });
        return future;
    }

    public static void main(String[] args) {
        MultithreadedUI ui = new MultithreadedUI();

        // Example of updating UI from another thread
        ui.updateUI(() -> {
            ui.frame.add(new JLabel("Hello from UI thread"));
            ui.frame.pack();
            ui.frame.setVisible(true);
        });

        // Background task that updates the UI later
        CompletableFuture<String> backgroundTask = ui.executeTask(() -> {
            Thread.sleep(2000); // Simulate a long-running operation
            return "Hello from background thread";
        });

        // Update UI with result of the background task
        backgroundTask.thenAccept(result ->
            ui.updateUI(() -> {
                JLabel label = new JLabel(result);
                ui.frame.add(label);
                ui.frame.pack();  // Re-pack the frame after adding new label
            })
        );
    }
}