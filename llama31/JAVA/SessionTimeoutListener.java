import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionTimeoutListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        String headerValue = request.getHeader("your-header-name");
        HttpSession session = request.getSession();
        // set the session timeout based on the header value
        int yourTimeoutValue = 30; // Replace with your desired value
        session.setMaxInactiveInterval(yourTimeoutValue);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // nothing to do here
    }

    public static void main(String[] args) {
    }
}