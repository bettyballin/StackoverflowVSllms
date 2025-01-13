import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    public static void main(String[] args) {
        // Note: In a real-world scenario, you would get the HttpServletResponse object from a servlet or a web framework.
        // For demonstration purposes, we'll just create a mock implementation.
        HttpServletResponse response = new MockHttpServletResponse();

        Cookie cookie = new Cookie("myCookie", "myValue");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }

    // Mock implementation for demonstration purposes only.
    static class MockHttpServletResponse implements HttpServletResponse {
        @Override
        public void addCookie(Cookie cookie) {
            System.out.println("Adding cookie: " + cookie.getName() + "=" + cookie.getValue());
        }

        // Implement other HttpServletResponse methods as needed for your use case.
    }
}