/*
 * Decompiled with CFR 0.152.
 */
class LogEntry {
    private String message;
    private Level level;

    public LogEntry(String string, Level level) {
        this.message = string;
        this.level = level;
    }

    public String getMessage() {
        return this.message;
    }

    public Level getLevel() {
        return this.level;
    }

    public static enum Level {
        INFO,
        ERROR;

    }
}
