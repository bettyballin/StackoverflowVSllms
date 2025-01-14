import java.util.HashMap;
import java.util.Map;

public class SessionVariable {
    public enum SessionVar {
        MYVAR1,
        MYVAR2,
        MYVAR3,
        MYVAR4;

        @Override
        public String toString() {
            return this.name().toLowerCase();
        }
    }

    static Map<String, Object> session = new HashMap<>();

    // Usage
    static {
        Object something = new Object();
        session.put(SessionVar.MYVAR1.toString(), something);
        session.put(SessionVar.MYVAR2.toString(), something);
    }

    public static void main(String[] args) {
        // Example of accessing session variables
        System.out.println("Session Variable MYVAR1: " + session.get("myvar1"));
        System.out.println("Session Variable MYVAR2: " + session.get("myvar2"));
    }
}