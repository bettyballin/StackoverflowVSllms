import java.lang.String;

public class UserActionorLoadUserDetails {
    private UserManager userManager;
    private int id;
    private static final String SUCCESS = "success";
    
    public String execute() throws Exception {
        CgUsers user = userManager.getUser(id);
        ServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("Userdetail", user); // Setting the attribute in the request scope
        return SUCCESS;
    }
	
    public static void main(String[] args) {
        // You can add code here to test the execute method if needed
    }
}

class CgUsers {
    // Empty class representing user details
}

class UserManager {
    public CgUsers getUser(int id) {
        return new CgUsers();
    }
}

class ServletRequest {
    public void setAttribute(String name, Object value) {
        // Method to set an attribute in the request scope
    }
}

class ServletActionContext {
    public static ServletRequest getRequest() {
        return new ServletRequest();
    }
}