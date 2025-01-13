import org.apache.struts2.dispatcher.ServletDispatcherResult;
import com.opensymphony.xwork2.ActionInvocation;
import your.package.User; // Replace 'your.package' with the actual package name where User class is defined

public class RoleBasedResult extends ServletDispatcherResult {
    @Override
    public void doExecute(String finalLocation, ActionInvocation invocation) throws Exception {
        String role = ((User) invocation.getInvocationContext().getSession().get("user")).getRole();
        String location = role.equals("customer") ? "/customer" + finalLocation : "/employee" + finalLocation;
        super.doExecute(location, invocation);
    }

    public static void main(String[] args) {
        // This main method doesn't actually test the functionality of the class.
        // For testing, consider using a testing framework like JUnit, or ensure
        // you have a proper Struts 2 application setup where this result type can be utilized.
    }
}