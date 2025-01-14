import java.lang.String;
public class Test_3 {

    // Static object used as a lock
    private static final Object someObjectLock = new Object();

    public void doSomething() {
        synchronized (someObjectLock) {
            // Critical section: only one thread can execute this at a time
            System.out.println(someObjectLock.toString());
            // Add other critical operations here
        }
    }


	public static void main(String[] args) {
	}
}