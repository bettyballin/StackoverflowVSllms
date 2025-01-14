import java.lang.String;
public class Counter_2 {
    private int count = 0;

    public void increment() {
        synchronized (this) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }

	public static void main(String[] args) {
	}
}