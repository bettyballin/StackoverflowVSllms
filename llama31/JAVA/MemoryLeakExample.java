import java.lang.String;
import java.util.List;
import java.util.ArrayList;

public class MemoryLeakExample {
    private static List<byte[]> list = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            list.add(new byte[1024 * 1024]); // allocate 1MB
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}