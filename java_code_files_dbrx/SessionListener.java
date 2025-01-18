import java.lang.String;
import java.util.Enumeration;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionListener implements HttpSessionAttributeListener {
    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        // Empty implementation to satisfy Servlet specification requirements.
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        // Empty implementation to satisfy Servlet specification requirements.
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        HttpSession session = (HttpSession) event.getSource();
        String attributeNameToRemove = "attribute_name";
        if (event.getName().equalsIgnoreCase(attributeNameToRemove)) {
            synchronized (session) {
                Enumeration<String> sessionAttributeNames = session.getAttributeNames();
                while (sessionAttributeNames.hasMoreElements()) {
                    // Remove the attribute from each active HttpSession.
                    String name = sessionAttributeNames.nextElement();
                    if (name.equalsIgnoreCase(attributeNameToRemove)) {
                        session.removeAttribute(name);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}