import java.util.ArrayList;
import java.util.List;

public class SchedulerProcessManager {

    private final List<Process> runningProcesses = new ArrayList<>();

    public void startProcess(String command) throws Exception {
        Process process = Runtime.getRuntime().exec(command);
        runningProcesses.add(process);

        // Optional: Thread management with reading output and errors
        Thread thread1 = new Thread(new ReaderThread(process.getInputStream()));
        Thread thread2 = new Thread(new ReaderThread(process.getErrorStream()));

        thread1.start();
        thread2.start();

        // Wait for the process to finish if you care about that, otherwise, just proceed
        // Note: If your scheduler stops before processing completes, it will be forcefully terminated in shutdown hook.
    }

    public void initShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down gracefully...");
            for (Process process : runningProcesses) {
                if (process.isAlive()) {
                    process.destroy(); // Send a terminate signal to the process
                    try {
                        process.waitFor(); // Wait for it to exit
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }));
    }

    public static void main(String[] args) {
        SchedulerProcessManager manager = new SchedulerProcessManager();
        manager.initShutdownHook();

        try {
            manager.startProcess("java -version"); // Example command
            // Add your job configurations here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class ReaderThread implements Runnable {
        private final java.io.InputStream stream;

        public ReaderThread(java.io.InputStream stream) {
            this.stream = stream;
        }

        @Override
        public void run() {
            try (java.util.Scanner s = new java.util.Scanner(stream).useDelimiter("\\A")) {
                String result = s.hasNext() ? s.next() : "";
                System.out.println(result);
            }
        }
    }
}