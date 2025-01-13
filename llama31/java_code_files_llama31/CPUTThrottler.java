/*
 * Decompiled with CFR 0.152.
 */
public class CPUTThrottler {
    private static final long TIME_WINDOW = 1000L;
    private static final double CPU_USAGE_LIMIT = 0.5;
    private long startTime;
    private long sleepTime;

    public void throttle() {
        this.startTime = System.currentTimeMillis();
        this.sleepTime = 0L;
        while (true) {
            long l;
            long l2;
            if ((l2 = (l = System.currentTimeMillis()) - this.startTime) <= 1000L) {
                continue;
            }
            double d = (double)(l2 - this.sleepTime) / 1000.0;
            if (d > 0.5) {
                this.sleepTime += 1000L - (long)(d * 1000.0);
                try {
                    Thread.sleep(this.sleepTime);
                }
                catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                }
            }
            this.startTime = l;
            this.sleepTime = 0L;
        }
    }

    public static void main(String[] stringArray) {
    }
}
