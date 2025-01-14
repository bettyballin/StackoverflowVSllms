import java.lang.String;
class ResourceManager1 {
    private final Object mutex = new Object();
    private Object resource;

    public Object getResource() {
        synchronized (mutex) {
            if (resource == null) {
                resource = new Object();
            }
        }
        return resource;
    }
}

public class ResourceManager2 {
    private final Object mutex = new Object();
    private Object resource;

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