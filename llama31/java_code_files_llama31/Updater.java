/*
 * Decompiled with CFR 0.152.
 */
public class Updater {
    public static void main(String[] stringArray) {
        UpdaterThread updaterThread = new UpdaterThread();
        updaterThread.start();
        updaterThread.shutdown();
    }

    private static class UpdaterThread
    extends Thread {
        private volatile boolean interrupted = false;

        private UpdaterThread() {
        }

        @Override
        public void run() {
            while (!this.interrupted) {
            }
        }

        public void shutdown() {
            this.interrupted = true;
            try {
                this.join();
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
