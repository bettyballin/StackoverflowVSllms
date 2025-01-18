public class MyActionClass {
    private String someParam;
    public static final String SUCCESS = "success";

    public String execute() throws Exception {
        // Implementation code here
        this.someParam = "some value";
        return SUCCESS;
    }

    // Getter and Setter methods
    public String getSomeParam() {
        return someParam;
    }

    public void setSomeParam(String someParam) {
        this.someParam = someParam;
    }
}