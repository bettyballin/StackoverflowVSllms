public class SessionExample {

    public static void main(String[] args) {

        HttpServletRequest request = new HttpServletRequest();
        HttpServletResponse response = new HttpServletResponse();

        // Example Java code snippet for setting session expiration
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(14 * 24 * 60 * 60); // Set session to expire in 2 weeks

        // Optional: Use cookies securely
        Cookie rememberMeCookie = new Cookie("remember_me", "token");
        rememberMeCookie.setHttpOnly(true);
        rememberMeCookie.setSecure(true); // Ensure cookie is sent over HTTPS only
        response.addCookie(rememberMeCookie);

        // Set token expiry in the database or other secure storage to 2 weeks from now

    }

    static class HttpServletRequest {
        public HttpSession getSession() {
            return new HttpSession();
        }
    }

    static class HttpServletResponse {
        public void addCookie(Cookie cookie) {
            // Do nothing
        }
    }

    static class HttpSession {
        public void setMaxInactiveInterval(int interval) {
            // Do nothing
        }
    }

    static class Cookie {
        private String name;
        private String value;

        public Cookie(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public void setHttpOnly(boolean flag) {
            // Do nothing
        }

        public void setSecure(boolean flag) {
            // Do nothing
        }
    }

}