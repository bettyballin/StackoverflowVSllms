import java.lang.String;

public class UserDetailSetter {
    public static void main(String[] args) {
        ActionContext.getContext().getRequest().setAttribute("Userdetail", getUserdetail());
    }

    // Assuming getUserdetail() and ActionContext are defined elsewhere in your codebase
    // If not, you'll need to implement or import them
    // For example:
    // public static Object getUserdetail() { return new Object(); }
    // import com.opensymphony.xwork2.ActionContext;
}