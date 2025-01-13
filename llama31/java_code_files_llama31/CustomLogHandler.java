/*
 * Decompiled with CFR 0.152.
 */
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class CustomLogHandler
extends Handler {
    @Override
    public void publish(LogRecord logRecord) {
        System.out.println(logRecord.getMessage());
    }

    @Override
    public void flush() {
    }

    @Override
    public void close() throws SecurityException {
    }

    public static void main(String[] stringArray) {
    }
}
