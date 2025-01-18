import java.lang.String;
import java.util.concurrent.locks.ReentrantLock;

public class ResourceManager {
    private static final Object LOCK = new Object(); // Create a unique final lock object
    private Object resource = null;

    public Object getResource()
    {
        synchronized (LOCK) // Correct spelling of "synchronized" and using proper lock object
        {
            if (resource == null) {
                resource = new Object();
            }
        }

        return resource;
    }

	public static void main(String[] args) {
	}
}