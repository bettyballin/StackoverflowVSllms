import java.util.HashMap;
import java.util.Map;

public class SessionManager_2 {

    // Minimal implementation of HttpSession
    class HttpSession {
        private Map<String, Object> attributes = new HashMap<>();

        public void setAttribute(String name, Object value) {
            attributes.put(name, value);
        }

        public Object getAttribute(String name) {
            return attributes.get(name);
        }
    }

    // Minimal implementation of HttpServletRequest
    class HttpServletRequest {
        private HttpSession session = new HttpSession();

        public HttpSession getSession() {
            return session;
        }
    }

    public void doSomething() {
        HttpServletRequest request = new HttpServletRequest();

        // Setting the session attribute
        HttpSession session = request.getSession();
        session.setAttribute("isLogin", true);

        // Retrieving the session attribute
        boolean isLoggedIn = (Boolean) session.getAttribute("isLogin");

        System.out.println("Is logged in: " + isLoggedIn);
    }

    public static void main(String[] args) {
        SessionManager_2 manager = new SessionManager_2();
        manager.doSomething();
    }
}