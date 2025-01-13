import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SessionInterceptor implements Interceptor {

    @Override
    public void destroy() {
    }

    @Override
    public void init() {
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        // Check if user is logged in
        if (invocation.getInvocationContext().getSession().get("loggedInUser") == null) {
            // Redirect to login page
            return "login";
        } else {
            // Proceed with the action
            return invocation.invoke();
        }
    }

    public static void main(String[] args) {
    }
}