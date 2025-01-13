import java.util.HashMap;
import java.util.Map;

public class ClientSessionManager {
    private static Map<String, Object> Session = new HashMap<>();

    public int getCurrentClientID() {
        return (int) Session.get("ClientID");
    }

    public static void main(String[] args) {
        ClientSessionManager csm = new ClientSessionManager();
        Session.put("ClientID", 1);
        System.out.println(csm.getCurrentClientID());
    }
}