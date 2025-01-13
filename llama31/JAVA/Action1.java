import com.opensymphony.xwork2.ActionSupport;

public class Action1 extends ActionSupport {
    private String param1;

    public String execute() {
        // set param1 value
        param1 = "some value";
        return SUCCESS;
    }

    public String getParam1() {
        return param1;
    }

    public static void main(String[] args) {
    }
}