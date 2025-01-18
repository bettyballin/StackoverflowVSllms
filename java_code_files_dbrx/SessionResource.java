import java.lang.String;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.NewCookie;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

@Path("/session")
public class SessionResource {

    @Context
    private HttpServletRequest request;

    @POST
    public Response login(String username) {
        // Perform authentication logic here, e.g. validate credentials against a database
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        return Response.ok().cookie(new NewCookie("JSESSIONID", session.getId(), "/")).build();
    }

    @DELETE
    public Response logout() {
        if (request.getSession(false) != null) {
            request.getSession().invalidate();
        }
        return Response.ok().cookie(new NewCookie("JSESSIONID", "", "/")).build();
    }

    public static void main(String[] args) {
    }
}