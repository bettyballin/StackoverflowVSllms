import java.lang.Integer;
import java.lang.String;
import java.util.concurrent.ConcurrentHashMap;

public class Cache_2 {
    private final ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
    private final Object file = new Object();

    public void deleteRecord(int index) {
        synchronized (file) {
            // file.deleteRecord(index);
            map.remove(index);
        }
    }

    public void writeRecord(int index, String record) {
        synchronized (file) {
            // file.writeRecord(index, record);
            map.put(index, record);
        }
    }

    public String getRecord(int index) {
        return map.get(index); // thread-safe, no need for synchronization
    }

	public static void main(String[] args) {
	}
}