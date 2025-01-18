import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

public class SessionListener implements HttpSessionAttributeListener, HttpSessionListener {
    // Code unchanged...

    public void sessionDestroyed(HttpSessionEvent event) {
        String clientIP = "Unknown IP"; // Get the IP of who is closing session (for logging purposes).
        long destroyedTime = System.currentTimeMillis() - event.getSession().getCreationTime(); // Calculate time from created till deleted for this session (in milliseconds).
        HttpSession session = event.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) { // Retrieve all attribute values of the destroyed Session.
            String attributeName = attributeNames.nextElement();
            if (!session.isNew() && attributeName != null) { // To avoid null pointer exceptions from new or empty sessions while logging.
                System.out.println("Session Attribute " + attributeName + "=" + session.getAttribute(attributeName) + " was destroyed!");
            }
        }
    }

    public static void main(String[] args) {
    }
}