import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class Navigator {
    public static void main(String[] args) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        externalContext.redirect(externalContext.getRequestContextPath() + "/page2.xhtml");
    }
}