import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.security.Principal;
import java.io.Serializable;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

@ManagedBean(name="securedBeans") // Any Name
@SessionScoped
public class SecuredBeans implements Serializable {
    private static final long serialVersionUID = 1L;

    private Principal userPrincipal;
    private String roleCheck;

    // Default constructor
    public SecuredBeans() {
        // Initialize any necessary fields here
    }

    // Getter and setter for userPrincipal
    public Principal getUserPrincipal() {
        return userPrincipal;
    }

    public void setUserPrincipal(Principal userPrincipal) {
        this.userPrincipal = userPrincipal;
    }

    // Getter and setter for roleCheck
    public String getRoleCheck() {
        return roleCheck;
    }

    public void setRoleCheck(String roleCheck) {
        this.roleCheck = roleCheck;
    }

    public boolean hasRole(String check) { // Your Role-based code here
        if (userPrincipal == null || getUserRole() == null) return false;
        try {
            Collection<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(getUserRole());
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equalsIgnoreCase(check)) return true; // Matches a role, so returns positive
            }
        } catch (Exception e) {
            // TBD
            e.printStackTrace();
        }
        return false; // Does not match a given role
    }

    public String getUserRole() { 
        if (userPrincipal == null || userPrincipal.getName() == null) return ""; 
        // This has to be updated based on your UserPrincipal roles
        // For now, returning an empty string or a placeholder
        return ""; 
    }

    // Other methods such as getters and setters
}