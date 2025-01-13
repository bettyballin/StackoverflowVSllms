import javax.faces.context.FacesContext;
import javax.faces.application.NavigationHandler;

public class FacesNavigationExample {
    
    public void navigateIfValidationFailed() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (facesContext == null) {
            System.out.println("FacesContext is null, this method should be called within a JSF lifecycle.");
            return;
        }
        
        String viewId = facesContext.getViewRoot().getViewId();
        String fooId = facesContext.getExternalContext().getRequestParameterMap().get("id");

        if (facesContext.isValidationFailed()) {
            NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
            navigationHandler.handleNavigation(facesContext, null, "/foo.xhtml?id=" + fooId);
        }
    }

    public static void main(String[] args) {
        FacesNavigationExample example = new FacesNavigationExample();
        System.out.println("This program should be run within a JSF application context.");
    }
}