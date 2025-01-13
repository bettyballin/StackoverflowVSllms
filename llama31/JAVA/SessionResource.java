import java.lang.String;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Path("/session")
public class SessionResource {
    @PUT
    @Path("/{username}")
    public void login(@PathParam("username") String username, @Context HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.setAttribute("username", username);
    }

    @DELETE
    @Path("/{username}")
    public void logout(@PathParam("username") String username, @Context HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }

    public static void main(String[] args) {
    }
}