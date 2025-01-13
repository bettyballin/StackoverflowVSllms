import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class MyAction extends ActionSupport {
    @Override
    public String execute() {
        // Your action code here
        return SUCCESS;
    }

    public static void main(String[] args) {
    }
}