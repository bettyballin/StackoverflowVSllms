/*
 * Decompiled with CFR 0.152.
 */
private static class MemoryMonitorAgent.MemoryMonitor
implements Thread.UncaughtExceptionHandler {
    private final long maxMemory;

    public MemoryMonitorAgent.MemoryMonitor(long l) {
        this.maxMemory = l;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        if (throwable instanceof OutOfMemoryError) {
            thread.interrupt();
        }
    }
}
