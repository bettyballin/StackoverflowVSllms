public class SessionExample {
    public static void main(String[] args) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(true);
        httpSession.setAttribute("username", "John Doe"); // To save a value in the session
        String user = (String) httpSession.getAttribute("username"); // To retrieve a value from the session
        System.out.println("Username from session: " + user);
    }
}

class FacesContext {
    private static FacesContext instance = new FacesContext();
    private ExternalContext externalContext = new ExternalContext();

    public static FacesContext getCurrentInstance() {
        return instance;
    }

    public ExternalContext getExternalContext() {
        return externalContext;
    }
}

class ExternalContext {
    public Object getSession(boolean create) {
        return new HttpSession();
    }
}

class HttpSession {
    private java.util.Map<String, Object> attributes = new java.util.HashMap<>();

    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    public Object getAttribute(String name) {
        return attributes.get(name);
    }
}