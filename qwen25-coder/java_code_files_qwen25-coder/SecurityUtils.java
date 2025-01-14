import java.security.Principal;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class SecurityUtils {

    public boolean hasUserRole(String role) {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        Principal principal = ec.getUserPrincipal();

        // Check if the user is in a specific role
        return principal != null && ec.isUserInRole(role);
    }

    public static void main(String[] args) {
    }
}