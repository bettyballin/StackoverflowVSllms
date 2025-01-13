/*
 * Decompiled with CFR 0.152.
 */
private static class HeartbeatSender.HeartbeatTask
implements Runnable {
    private final Server server;

    public HeartbeatSender.HeartbeatTask(Server server) {
        this.server = server;
    }

    @Override
    public void run() {
        this.server.sendHeartbeat();
    }
}
