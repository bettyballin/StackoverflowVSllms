public class MyClass {
    public static void main(String[] args) {
        UserPrincipal local = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        if(local != null && local.getName() != null) {
            //Your role-based code here
            System.out.println("User Name: " + local.getName());
        }
    }
}

interface UserPrincipal {
    String getName();
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
    public UserPrincipal getUserPrincipal() {
        return new UserPrincipal() {
            public String getName() {
                return "TestUser";
            }
        };
    }
}