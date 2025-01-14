public class Action2 extends ActionSupport {
    private String receivedParam;

    public String execute() throws Exception {
        // Use the parameter received from the previous action
        System.out.println("Received parameter: " + receivedParam);
        return SUCCESS;
    }

    public String getReceivedParam() {
        return receivedParam;
    }

    public void setReceivedParam(String receivedParam) {
        this.receivedParam = receivedParam;
    }

    public static void main(String[] args) {
    }
}

class ActionSupport {
    public static final String SUCCESS = "success";
}