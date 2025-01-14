import java.lang.String;
public class Counter_1 {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public static void main(String[] args) {
    }
}