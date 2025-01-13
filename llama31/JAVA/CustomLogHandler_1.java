import java.util.logging.Logger;
import java.util.logging.Handler;

public class CustomLogHandler_1_1 {
    public static void main(String[] args) {
        Logger.getLogger("").addHandler(new CustomLogHandler());
    }
}

class CustomLogHandler extends Handler {
    // You need to implement the following methods
    @Override
    public void publish(java.util.logging.LogRecord record) {
        // Your implementation here
    }

    @Override
    public void flush() {
        // Your implementation here
    }

    @Override
    public void close() throws SecurityException {
        // Your implementation here
    }
}