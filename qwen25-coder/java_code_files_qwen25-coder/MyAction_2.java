public class ActionSupport {
    public static final String SUCCESS = "success";
}

public class MyAction_2 extends ActionSupport {
    private String myfield;

    // Getter and Setter for myfield
    public String getMyfield() {
        return myfield;
    }

    public void setMyfield(String myfield) {
        this.myfield = myfield;
    }

    @Override
    public String execute() throws Exception {
        // Action logic here
        return SUCCESS;
    }

    public static void main(String[] args) {
    }
}