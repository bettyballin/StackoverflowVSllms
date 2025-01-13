/*
 * Decompiled with CFR 0.152.
 */
static class DaemonThreadFactory.1
implements ThreadFactory {
    DaemonThreadFactory.1() {
    }

    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        return thread;
    }
}
