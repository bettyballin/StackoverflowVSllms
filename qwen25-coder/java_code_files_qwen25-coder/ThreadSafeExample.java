import java.lang.String;
import java.lang.Integer;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafeExample {
    private ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

    public void myPut(int key, int value) {
        this.map.put(key, value);
    }

	public static void main(String[] args) {
	}
}