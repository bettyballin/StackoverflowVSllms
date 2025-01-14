public class CookieHelper {
    private Cookie getCookieByName(Cookie[] cookies, String name) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    return cookie;
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
    }
}

class Cookie {
    private String name;
    public Cookie(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}