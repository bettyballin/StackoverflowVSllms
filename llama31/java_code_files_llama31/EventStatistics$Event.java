/*
 * Decompiled with CFR 0.152.
 */
public static class EventStatistics.Event {
    private final Type type;
    private final long timestamp;

    public EventStatistics.Event(Type type) {
        this.type = type;
        this.timestamp = System.currentTimeMillis();
    }

    public Type getType() {
        return this.type;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public static enum Type {
        SUCCESS,
        FAILURE;

    }
}
