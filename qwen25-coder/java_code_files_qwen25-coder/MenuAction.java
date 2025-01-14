import java.util.Map;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts2.interceptor.SessionAware;

public class MenuAction extends ActionSupport implements Preparable, SessionAware {

    private transient Map<String, Object> session;
    private MenuBean servico;
    private Usuario usuario;

    public MenuAction(MenuBean servico) {
        this.servico = servico;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session; // Ensure the session map is being injected.
    }

    @Override
    public void prepare() throws Exception {
        if (session.containsKey(LoginInterceptor.USER_HANDLE)) {
            usuario = (Usuario) session.get(LoginInterceptor.USER_HANDLE);
        }
    }

    public String execute() {
        if (usuario == null || !session.containsKey(LoginInterceptor.USER_HANDLE)) {
            return INPUT;
        }
        setMenu(servico.getMenuPerfil(usuario.getPerfil()));
        return SUCCESS;
    }

    public static void main(String[] args) {
    }

    // Placeholder method to match setMenu call
    public void setMenu(Object menu) {
        // Implementation here
    }
}

// Auxiliary classes to make the code executable
class MenuBean {
    public Object getMenuPerfil(Object perfil) {
        // Implementation here
        return null;
    }
}

class Usuario {
    public Object getPerfil() {
        // Implementation here
        return null;
    }
}

class LoginInterceptor {
    public static final String USER_HANDLE = "USER_HANDLE";
}