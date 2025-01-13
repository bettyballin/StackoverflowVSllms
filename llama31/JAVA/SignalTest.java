import java.lang.String;
import sun.misc.Signal;
import sun.misc.SignalHandler;

public class SignalTest {
    private static ShutdownHandler handler = new ShutdownHandler();

    private static class ShutdownHandler implements SignalHandler {
        public void handle(Signal sig) {
        }
    }

    public static void main(String[] args) {
        try {
            Signal.handle(new Signal("INT"), handler);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}