// Minimal implementation of ActionSupport for compilation purposes
class ActionSupport {
    public static final String SUCCESS = "success";
}

import java.lang.String;
// Assume your action class extends ActionSupport or a similar base class
public class MyAction extends ActionSupport {
    private String lcItem;

    @Override
    public String execute() throws Exception {
        lcItem = "Hello";
        return SUCCESS;
    }

    // Getter method for Struts2 to access lcItem
    public String getLcItem() {
        return lcItem;
    }

    public static void main(String[] args) {
    }
}