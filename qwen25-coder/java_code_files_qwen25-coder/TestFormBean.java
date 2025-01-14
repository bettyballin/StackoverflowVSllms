import java.lang.String;

// Define the annotations to make the code executable
@interface ManagedBean {
    String name() default "";
}

@interface SessionScoped {
}

@ManagedBean(name = "testFormBean")
@SessionScoped
public class TestFormBean {
    private String testType;
    private String mode;

    // Getters and Setters
    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public static void main(String[] args) {
    }
}