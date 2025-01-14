import java.lang.String;
import javax.ejb.Stateless;
import java.util.concurrent.ConcurrentHashMap;

@Stateless
public class SharedResourceBean {
    private static final ConcurrentHashMap<String, String> sharedData = new ConcurrentHashMap<>();

    public void putData(String key, String value) {
        sharedData.put(key, value);
    }

    public String getData(String key) {
        return sharedData.get(key);
    }

	public static void main(String[] args) {
	}
}