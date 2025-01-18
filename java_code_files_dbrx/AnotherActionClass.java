class MyActionClass {
    private String someParam;

    public String execute() throws Exception {
        return null;
    }

    public String getSomeParam() {
        return someParam;
    }

    public void setSomeParam(String someParam) {
        this.someParam = someParam;
    }
}

public class AnotherActionClass extends MyActionClass {
    private String anotherParam;

    @Override
    public String execute() throws Exception {
        // ...
        System.out.println("Retrieved parameter from first action: " + getSomeParam());
        return null;
    }

    // getters and setters...
    public String getAnotherParam() {
        return anotherParam;
    }

    public void setAnotherParam(String anotherParam) {
        this.anotherParam = anotherParam;
    }
}