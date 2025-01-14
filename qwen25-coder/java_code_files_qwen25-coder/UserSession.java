import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Simulating session
class UserSession {
    private Map<String, Object> states = new HashMap<String, Object>();
    
    // Method to generate unique token and store state
    public String createNewView(Object state) {
        String token = UUID.randomUUID().toString();
        states.put(token, state);
        return token;
    }
    
    // Method to retrieve state using token
    public Object getState(String token) {
        return states.get(token);
    }
    
    // Method to remove state when view is closed (e.g., on logout or session expiry)
    public void removeState(String token) {
        states.remove(token);
    }
}

// Example usage in a servlet
public class ExhibitionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserSession session = (UserSession) request.getSession().getAttribute("userSession");
        
        if (session == null) {
            session = new UserSession();
            request.getSession().setAttribute("userSession", session);
        }
        
        // Generate a token for this view and store the selected exhibition state
        String currentStateToken = request.getParameter("stateToken");
        String newExhibitionId = request.getParameter("exhibitionId"); // Assume user has chosen an exhibition
        
        if (currentStateToken == null) {
            currentStateToken = session.createNewView(newExhibitionId);
        } else {
            session.getState(currentStateToken); // Retrieve current state
            session.removeState(currentStateToken); // Remove old if needed and update
            session.createNewView(newExhibitionId); // Store new state
        }
        
        response.getWriter().write("Generated / Retrieved State Token: " + currentStateToken);
    }
    
    // Other methods...

    public static void main(String[] args) {
    }
}