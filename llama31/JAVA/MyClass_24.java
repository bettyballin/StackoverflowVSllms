import java.util.LinkedHashMap;
import java.util.Map;

public class MyClass_24 {
  private final static int SIZE_LIMIT = 1000;
  private Map<Integer, Integer> cache =
    new LinkedHashMap<Integer, Integer>(16, 0.75f, true) {
      @Override
      protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > SIZE_LIMIT;
      }
  };

  public int myFunc(int n) {
    if(cache.containsKey(n))
      return cache.get(n);
    int next = n + 1; //some complicated math.  guaranteed next != n.
    int ret = 1 + myFunc(next);
    cache.put(n, ret);
    return ret;
  }

  public static void main(String[] args) {
    MyClass obj = new MyClass();
    System.out.println(obj.myFunc(10));
  }
}