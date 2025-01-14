import java.lang.String;
import java.util.Set;

public class Action1 extends ActionSupport {
    private String param;

    public String execute() throws Exception {
        // Set some parameter to pass to another action
        return SUCCESS;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public static void main(String[] args) {
    }
}

class ActionSupport {
    public static final String SUCCESS = "success";
}