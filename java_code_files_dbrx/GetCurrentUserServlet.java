import java.io.IOException;

// GetCurrentUserServlet.java
public class GetCurrentUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        // replace with your logic to get the User object.
        User currentUser = new User();  // Just an example for demonstration purposes.
        currentUser.setUserId("xyz");   // Set user details here.
        req.getSession().setAttribute("currentUser", currentUser);
    }

    public static void main(String[] args) {
    }
}

class HttpServlet {
}

class HttpServletRequest {
    public HttpSession getSession() {
        return new HttpSession();
    }
}

class HttpServletResponse {
}

class ServletException extends Exception {
}

class HttpSession {
    public void setAttribute(String name, Object value) {
        // Do nothing
    }
}

class User {
    private String userId;
    public void setUserId(String userId) {
        this.userId = userId;
    }
}