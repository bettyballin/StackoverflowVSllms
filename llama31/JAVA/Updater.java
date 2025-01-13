public class Updater {
    private static class UpdaterThread extends Thread {
        private volatile boolean interrupted = false;

        @Override
        public void run() {
            // ...
            while (!interrupted) {
                // ...
            }
        }

        public void shutdown() {
            interrupted = true;
            try {
                join(); // Wait for the thread to finish
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        UpdaterThread updater = new UpdaterThread();
        updater.start();
        // ...
        updater.shutdown();
    }
}