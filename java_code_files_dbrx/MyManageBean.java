import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean
@ViewScoped
public class MyManageBean {
    public String getSessionId() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
            .getExternalContext()
            .getRequest();
        HttpSession session = request.getSession(false);
        return session.getId(); // This will retrieve the SessionID as a string
    }

    public static void main(String[] args) {
    }
}