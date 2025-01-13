import java.lang.String;

// Define the annotation
@interface SkipValidation {
}

public class MyClass_5_5 {
    @SkipValidation
    public String myMethod() {
        // ...
        return "";
    }

    public static void main(String[] args) {
    }
}