import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.context.ExternalContext;

@ManagedBean
public class MyBean_4_4 {
    @EJB
    private MyEjb myEjb;

    public boolean isAdmin() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        return externalContext.isUserInRole("admin");
    }

    public static void main(String[] args) {
    }
}