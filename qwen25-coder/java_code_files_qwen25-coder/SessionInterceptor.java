import java.lang.String;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SessionInterceptor implements Interceptor {

    @Override
    public void init() {
        // Initialization code, if needed
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Object sessionUser = invocation.getInvocationContext().getSession().get("user");

        if (sessionUser == null) {
            return Action.LOGIN;  // Or redirect to a custom URL, see next step for more details
        } else {
            return invocation.invoke();
        }
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }

    public static void main(String[] args) {
    }
}