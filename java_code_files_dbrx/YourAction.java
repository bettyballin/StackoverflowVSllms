import java.lang.String;

// Define the ActionSupport class
public class ActionSupport {
    public static final String SUCCESS = "success";
    public static final String INPUT = "input";

    // ... other methods and properties ...
}

// Define the SkipValidation annotation
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface SkipValidation {
}

// The main class
public class YourAction extends ActionSupport {
    // ... other methods and properties ...

    private boolean yourCondition = true; // or set appropriately

    @SkipValidation
    public String conditionallyDisableValidation() throws Exception {
        if (yourCondition) {
            return INPUT; // or any result you want to use when validation is disabled.
        } else {
            return doYourNormalValidation();
        }
    }

    private String doYourNormalValidation() throws Exception {
        // Perform normal validations here ...
        return SUCCESS;
    }

    public static void main(String[] args) {
        // You can test the methods here if needed
    }
}