public class MyServlet {

    public void redirectToLogin(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // or SC_FORBIDDEN
        response.setHeader("Location", "login.jsp");  // URL of the login page
    }
}

interface HttpServletResponse {
    public static final int SC_UNAUTHORIZED = 401;
    void setStatus(int sc);
    void setHeader(String name, String value);
}