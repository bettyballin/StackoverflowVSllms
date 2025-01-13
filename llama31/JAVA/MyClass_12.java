import java.lang.String;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyClass_12 {
    private AtomicInteger val = new AtomicInteger(0);
    private AtomicIntegerArray ary = new AtomicIntegerArray(10);

    public void someMethod() {
        val.incrementAndGet(); // val++
        ary.addAndGet(0, 10); // ary[0] += 10
        ary.incrementAndGet(1); // ary[1]++
    }

	public static void main(String[] args) {
	}
}