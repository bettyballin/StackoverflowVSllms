// Necessary imports
import java.lang.String;

// Minimal ManagedBean annotation
@interface ManagedBean {}

// Minimal simulated FacesContext and related classes
class FacesContext {
    private static FacesContext instance = new FacesContext();
    private ExternalContext externalContext = new ExternalContext();

    public static FacesContext getCurrentInstance() {
        return instance;
    }

    public ExternalContext getExternalContext() {
        return externalContext;
    }
}

class ExternalContext {
    public Object getSession(boolean create) {
        return new HttpSession();
    }
}

// Minimal HttpSession class
class HttpSession {
    public String getId() {
        return "DummySessionID";
    }
}

@ManagedBean
public class SessionBean {

    public String getSessionId() {
        // Get the current FacesContext
        FacesContext context = FacesContext.getCurrentInstance();
        
        // Retrieve the HttpSession object from the FacesContext
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        
        // Check if session exists and return its ID, otherwise return null or a custom message
        return (session != null) ? session.getId() : "No active session found";
    }

    public static void main(String[] args) {
        SessionBean bean = new SessionBean();
        System.out.println("Session ID: " + bean.getSessionId());
    }
}