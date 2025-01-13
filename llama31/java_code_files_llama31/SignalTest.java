/*
 * Decompiled with CFR 0.152.
 */
import sun.misc.Signal;
import sun.misc.SignalHandler;

public class SignalTest {
    private static ShutdownHandler handler = new ShutdownHandler();

    public static void main(String[] stringArray) {
        try {
            Signal.handle(new Signal("INT"), handler);
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private static class ShutdownHandler
    implements SignalHandler {
        private ShutdownHandler() {
        }

        @Override
        public void handle(Signal signal) {
        }
    }
}
