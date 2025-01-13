/*
 * Decompiled with CFR 0.152.
 */
private static class LogMerger.Event {
    private long timestamp;
    private String data;

    public LogMerger.Event(long l, String string) {
        this.timestamp = l;
        this.data = string;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String toString() {
        return this.timestamp + "," + this.data;
    }
}
