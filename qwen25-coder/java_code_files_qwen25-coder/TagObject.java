import java.lang.String;
import java.util.Hashtable;

public class TagObject {
    private Hashtable<String, Object> attributes = new Hashtable<>();

    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    public Object getAttribute(String name) {
        return attributes.get(name);
    }

	public static void main(String[] args) {
	}
}