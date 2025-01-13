/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HeartbeatSender {
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public void startHeartbeat(Server server) {
        this.scheduler.scheduleAtFixedRate(new HeartbeatTask(server), 0L, 15L, TimeUnit.SECONDS);
    }

    public static void main(String[] stringArray) {
        Server server = new Server();
        HeartbeatSender heartbeatSender = new HeartbeatSender();
        heartbeatSender.startHeartbeat(server);
    }

    private static class HeartbeatTask
    implements Runnable {
        private final Server server;

        public HeartbeatTask(Server server) {
            this.server = server;
        }

        @Override
        public void run() {
            this.server.sendHeartbeat();
        }
    }
}
