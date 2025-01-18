import java.util.HashMap;
import java.util.Map;

public final class SessionContext {
    public static final String ORG_ID = "org_id";
    private static final ThreadLocal<Map<String, Object>> contextHolder = new InheritableThreadLocal<>();

    public static Map<String, Object> getAll() {
        return contextHolder.get();
    }

    public static void set(final String key, final Object value) {
        if (contextHolder.get() == null) {
            contextHolder.set(new HashMap<>());
        }
        contextHolder.get().put(key, value);
    }

    public static void clear() {
       contextHolder.remove();
    }

    public static void main(String[] args) {
    }

}