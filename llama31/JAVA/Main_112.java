import java.util.concurrent.atomic.AtomicInteger;

public class Main_112 {
    public static void main(String[] args) {
        AtomicInteger atomicX = new AtomicInteger(5);
        System.out.println(atomicX.incrementAndGet()); // thread-safe
    }
}