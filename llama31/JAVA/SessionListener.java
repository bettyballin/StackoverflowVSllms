import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

// Store all active sessions in the ServletContext
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        ServletContext context = event.getSession().getServletContext();
        Set<HttpSession> activeSessions = (Set<HttpSession>) context.getAttribute("activeSessions");
        if (activeSessions == null) {
            activeSessions = new HashSet<>();
            context.setAttribute("activeSessions", activeSessions);
        }
        activeSessions.add(event.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        ServletContext context = event.getSession().getServletContext();
        Set<HttpSession> activeSessions = (Set<HttpSession>) context.getAttribute("activeSessions");
        activeSessions.remove(event.getSession());
    }
}

// Clean session attributes from all active sessions
public class SessionCleaner {
    public void cleanSessionAttributes(ServletContext context) {
        Set<HttpSession> activeSessions = (Set<HttpSession>) context.getAttribute("activeSessions");
        for (HttpSession session : activeSessions) {
            session.removeAttribute("attributeName");
        }
    }

    public static void main(String[] args) {
    }
}