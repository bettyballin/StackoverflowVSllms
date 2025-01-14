import java.lang.String;
import java.lang.Integer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MyClass_1 {

    class MyClass {
        ConcurrentHashMap<Integer, AtomicInteger> map = new ConcurrentHashMap<>();

        public void someMethod() {
            for (int i = 0; i < map.size(); i++) {
                map.merge(i, new AtomicInteger(1), (existingValue, one) -> {
                    existingValue.incrementAndGet();
                    return existingValue;
                }); // Atomically add 1 to the existing value
            }
        }
    }

    public static void main(String[] args) {
    }
}