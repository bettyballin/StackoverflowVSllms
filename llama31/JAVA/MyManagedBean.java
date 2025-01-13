import java.lang.String;

// Commented out to avoid compilation errors without JSF libraries
//import javax.faces.context.FacesContext;
//import javax.servlet.http.HttpSession;

public class MyManagedBean {
    // This method requires JSF and Servlet API libraries
    // public String getSessionId() {
    //     FacesContext context = FacesContext.getCurrentInstance();
    //     HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
    //     return session.getId();
    // }

    public static void main(String[] args) {
        System.out.println("This is the main method.");
    }
}