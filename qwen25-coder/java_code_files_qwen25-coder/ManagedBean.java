// import javax.faces.context.FacesContext;
// import javax.servlet.http.HttpSession;

public class ManagedBean {

    public void method() {
        // Code snippet in any method of Managed Bean
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(true);
        String mySessionVar = (String) session.getAttribute("sessionVariableName");
        
        // You can add your logic here to use mySessionVar
    }
}

class FacesContext {
    private static FacesContext instance = new FacesContext();

    public static FacesContext getCurrentInstance() {
        return instance;
    }

    public ExternalContext getExternalContext() {
        return new ExternalContext();
    }
}

class ExternalContext {
    public HttpSession getSession(boolean create) {
        return new HttpSession();
    }
}

class HttpSession {
    public Object getAttribute(String name) {
        return null;
    }
}