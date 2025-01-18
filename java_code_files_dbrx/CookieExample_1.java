// Set Cookie as Expired - Java
public class CookieExample {

    // Minimal Cookie class
    public static class Cookie {
        public Cookie(String name, String value) {
            // Constructor implementation
        }

        public void setMaxAge(int expiry) {
            // Method implementation
        }
    }

    // Minimal HttpServletResponse interface
    public interface MyHttpServletResponseInterface {
        void addCookie(Cookie cookie);
    }

    // Minimal implementation of HttpServletResponse
    public static class MyHttpServletResponse implements MyHttpServletResponseInterface {
        public void addCookie(Cookie cookie) {
            // Method implementation
        }
    }

    public static void main(String[] args) {
        final MyHttpServletResponseInterface response = new MyHttpServletResponse(); // Your HttpServletResponse Object
        final String cookieName = "session-cookie";  // Name of your session/authentication cookie
        Cookie c = new Cookie(cookieName, null);
        c.setMaxAge(0);
        response.addCookie(c);
    }
}