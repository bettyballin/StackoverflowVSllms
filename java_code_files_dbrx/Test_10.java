import java.lang.String;
import java.util.concurrent.locks.*;

public class Test_10 {
    private final Lock myLock = new ReentrantLock();
    public void foo() {
        myLock.lock();  // block until condition holds
        try {
            // ... method body
        } finally {
            myLock.unlock();  // release lock
        }
   }

	public static void main(String[] args) {
	}
}