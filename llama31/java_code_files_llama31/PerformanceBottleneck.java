/*
 * Decompiled with CFR 0.152.
 */
public class PerformanceBottleneck {
    public void slowMethod() {
        for (int i = 0; i < 1000000; ++i) {
            this.databaseQuery();
        }
    }

    private void databaseQuery() {
        try {
            Thread.sleep(10L);
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] stringArray) {
    }
}
