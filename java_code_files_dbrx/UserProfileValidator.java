public final class UserProfileValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserProfile.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "error.required"); // This will automatically fail bean value validation if id is null/zero
        UserProfile userProfile = (UserProfile) obj;
        // Your additional custom validations here based on other fields in userProfile ...
    }

    public static void main(String[] args) {
    }
}

// Minimal interface Validator
interface Validator {
    boolean supports(Class<?> clazz);
    void validate(Object obj, Errors errors);
}

// Minimal class Errors
class Errors {
    public void reject(String errorCode) {
    }
}

// Minimal class ValidationUtils
class ValidationUtils {
    public static void rejectIfEmptyOrWhitespace(Errors errors, String fieldName, String errorCode) {
    }
}

// Minimal class UserProfile
class UserProfile {
    // Fields and methods as needed
}