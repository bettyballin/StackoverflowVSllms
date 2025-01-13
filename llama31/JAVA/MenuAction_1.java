import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.Action;

public class MenuAction_1_1 extends ActionSupport implements Preparable {
    public String execute() {
        ActionContext context = ActionContext.getContext();
        // Assuming Session is meant to be the HttpSession object, you would access it like this:
        // HttpSession session = (HttpSession) context.getSession();
        // However, the direct getSession() method does not exist in ActionContext.
        // If Session is a custom object, ensure it's correctly accessible or instantiated.
        // For demonstration, let's just print a message.
        System.out.println("Execute method called.");
        return Action.SUCCESS;
    }

    @Override
    public void prepare() throws Exception {
        // Preparation logic before other methods are called.
        System.out.println("Prepare method called.");
    }

    public static void main(String[] args) {
        // This main method is not typically used in a Struts 2 web application,
        // as the framework handles the lifecycle of actions. However, for testing purposes:
        MenuAction_1 action = new MenuAction_1();
        try {
            action.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
        action.execute();
    }
}