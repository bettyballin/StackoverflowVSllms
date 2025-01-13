import java.lang.String;
public class MyClass_33 {
    private final Object lock = new Object();

    public void method1() {
        synchronized (lock) {
            // critical section
        }
    }

    public void method2() {
        synchronized (lock) {
            // critical section
        }
    }

	public static void main(String[] args) {
	}
}