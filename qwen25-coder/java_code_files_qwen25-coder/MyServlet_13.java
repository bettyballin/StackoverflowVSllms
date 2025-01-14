public class MyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        // In your login Servlet or where you set the session after successful authentication
        String username = request.getParameter("username");  // Get the username from the request
        HttpSession session = request.getSession();
        session.setAttribute("username", username);  // Set the username attribute
    }

    // Minimal stubs to make the code executable with javac
    public static class HttpServlet {
        // Empty stub class
    }

    public static class HttpServletRequest {
        public String getParameter(String name) {
            return "";  // Stub method
        }

        public HttpSession getSession() {
            return new HttpSession();  // Stub method
        }
    }

    public static class HttpServletResponse {
        // Empty stub class
    }

    public static class HttpSession {
        public void setAttribute(String name, Object value) {
            // Stub method
        }
    }

    public static class ServletException extends Exception {
        // Empty stub class
    }
}