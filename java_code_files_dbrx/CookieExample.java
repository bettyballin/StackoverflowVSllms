class Cookie {
    private String name;
    private String value;
    private int maxAge;

    public Cookie(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public void setMaxAge(int expiry) {
        this.maxAge = expiry;
    }
}

class HttpServletResponse {
    public void addCookie(Cookie cookie) {
        // Implementation not needed for this example
    }
}

public class CookieExample {

    public static void main(String[] args) {
        Cookie newCookie = new Cookie("cookieName", "cookieValue"); // create a new cookie object called 'newCookie'
        newCookie.setMaxAge(60 * 60);                       // Set maximum age to 3600 seconds or one hour (just an example)
        HttpServletResponse response = new HttpServletResponse();
        response.addCookie(newCookie);   // finally add this new cookie called 'newCookie' in the response header
    }
}