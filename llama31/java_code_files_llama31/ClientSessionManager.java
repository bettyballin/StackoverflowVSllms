/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

public class ClientSessionManager {
    private static Map<String, Object> Session = new HashMap<String, Object>();

    public int getCurrentClientID() {
        return (Integer)Session.get("ClientID");
    }

    public static void main(String[] stringArray) {
        ClientSessionManager clientSessionManager = new ClientSessionManager();
        Session.put("ClientID", 1);
        System.out.println(clientSessionManager.getCurrentClientID());
    }
}
