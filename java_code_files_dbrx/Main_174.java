import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {
        AtomicBoolean interrupt = new AtomicBoolean(false);

        while (!interrupt.get()) {
            // ...
        }
    }
}