/*
 * Decompiled with CFR 0.152.
 */
private static class Updater.UpdaterThread
extends Thread {
    private volatile boolean interrupted = false;

    private Updater.UpdaterThread() {
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
