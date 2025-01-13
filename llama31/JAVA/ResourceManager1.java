import java.lang.String;
public class ResourceManager1 {
    private final Object mutex = new Object();
    Object resource = null;

    public Object getResource() {
        synchronized (mutex) {
            if (resource == null) {
                resource = new Object();
            }
        }

        return resource;
    }

	public static void main(String[] args) {
	}
}