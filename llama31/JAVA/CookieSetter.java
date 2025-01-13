import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieSetter {
    public static void main(String[] args) {
        String refererUrl = "https://example.com"; // Replace with your desired referer URL
        HttpServletResponse response = null; // You need to get the HttpServletResponse object from your Servlet or JSP context

        Cookie cookie = new Cookie("refererUrl", refererUrl);
        cookie.setPath("/"); // Set the path to "/"
        
        // Assuming you have a HttpServletResponse object
        if (response != null) {
            response.addCookie(cookie);
        } else {
            System.out.println("No HttpServletResponse object available.");
        }
    }
}