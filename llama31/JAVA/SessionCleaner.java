import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionInformation;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

// Clean session attributes from all active sessions using Spring Security's SessionRegistry
public class SessionCleaner {
    @Autowired
    private SessionRegistry sessionRegistry;

    public void cleanSessionAttributes() {
        List<SessionInformation> sessions = sessionRegistry.getAllSessions();
        for (SessionInformation session : sessions) {
            session.expireNow();
            HttpSession httpSession = session.getSession();
            httpSession.removeAttribute("attributeName");
        }
    }

    public static void main(String[] args) {
        // Create an instance of SessionCleaner
        SessionCleaner cleaner = new SessionCleaner();
        // You need to set the sessionRegistry before calling cleanSessionAttributes()
        // This can be done using Spring's ApplicationContext or manually
        // For manual usage, you would need to create a SessionRegistry instance and set it
        // For example:
        // cleaner.sessionRegistry = new SessionRegistryImpl();
        // cleaner.cleanSessionAttributes();
    }
}