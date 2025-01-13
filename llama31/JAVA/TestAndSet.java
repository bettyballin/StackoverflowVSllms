import java.lang.String;
public class TestAndSet {
    private volatile boolean flag = false;

    public synchronized boolean testAndSet() {
        if (!flag) {
            flag = true;
            return true; // successfully set
        }
        return false; // already set
    }

    public synchronized void reset() {
        flag = false;
    }

	public static void main(String[] args) {
	}
}