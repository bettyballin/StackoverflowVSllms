import java.lang.String;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class CustomLogHandler extends Handler {
    @Override
    public void publish(LogRecord record) {
        // Log to file or console instead of system log
        System.out.println(record.getMessage());
    }

    @Override
    public void flush() {
        // No-op
    }

    @Override
    public void close() throws SecurityException {
        // No-op
    }

	public static void main(String[] args) {
	}
}