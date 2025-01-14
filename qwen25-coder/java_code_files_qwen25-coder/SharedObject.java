import java.lang.String;
// SharedObject.java
public class SharedObject {
    private boolean shouldTerminate = false;

    public synchronized void setShouldTerminate(boolean value) {
        this.shouldTerminate = value;
    }

    public synchronized boolean getShouldTerminate() {
        return this.shouldTerminate;
    }

	public static void main(String[] args) {
	}
}