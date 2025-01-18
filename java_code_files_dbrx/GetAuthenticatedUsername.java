import javax.servlet.http.HttpServletRequest;
import javax.faces.context.FacesContext;
import java.security.Principal;

public class GetAuthenticatedUsername {
    HttpServletRequest request;
    Principal userPrincipal;
    String username;

    public GetAuthenticatedUsername() {
        request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        userPrincipal = request.getUserPrincipal();
        username = userPrincipal != null ? userPrincipal.getName() : "anonymous";
    }

    public static void main(String[] args) {
    }
}