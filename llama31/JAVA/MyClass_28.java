import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class MyClass_28_28 {
  private static ConcurrentHashMap<String, List<String>> concurrentMap = new ConcurrentHashMap<>();

  public void doWork(String key) {
    List<String> values = null;
    while ((values = concurrentMap.remove(key)) != null) {
      //do something with values
    }
  }

  public static void addToMap(String key, String value) {
    concurrentMap.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
  }

	public static void main(String[] args) {
	}
}