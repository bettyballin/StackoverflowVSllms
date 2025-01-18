import java.util.Map;

public class SessionInterceptor extends AbstractInterceptor {

    public String intercept(ActionInvocation invocation) throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        if (session.containsKey("user")) { // Check if user logged in by adding a custom key to Session (example "user")
            return invocation.invoke();
        } else {
            return "login";  // redirecting to login action or any specific place you want the unauthenticated users go to
        }
    }

    public static void main(String[] args) {
    }
}

abstract class AbstractInterceptor {
    // Abstract class with no implementation
}

class ActionContext {
    private static ActionContext context = new ActionContext();
    private Map<String, Object> session = new java.util.HashMap<String, Object>();

    public static ActionContext getContext() {
        return context;
    }

    public Map<String, Object> getSession() {
        return session;
    }
}

class ActionInvocation {
    public String invoke() throws Exception {
        // Placeholder implementation
        return "";
    }
}