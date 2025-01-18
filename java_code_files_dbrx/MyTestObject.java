class MyTestObject {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

interface Errors {
    // Empty interface
}

class ValidationUtils {
    public static void rejectIfEmptyOrWhitespace(Errors errors, String field, String errorCode) {
        // Empty method implementation
    }
}

interface Validator {
    boolean supports(Class<?> clazz);

    void validate(Object object, Errors errors);
}

public class TestValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return MyTestObject.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.name.required");
    }
}