import java.lang.String;

public class ErrorMessageResolver {
    public String getErrorMessages(int code) {
        switch (code) {
            case 101:
                return "Invalid username";
            case 102:
                return "Invalid password";
            case 201:
                return "Database connection failed";
            case 202:
                return "Invalid query";
            default:
                return "Unknown error";
        }
    }

    public static void main(String[] args) {
        ErrorMessageResolver resolver = new ErrorMessageResolver();
        System.out.println(resolver.getErrorMessages(101));  // Output: Invalid username
        System.out.println(resolver.getErrorMessages(102));  // Output: Invalid password
        System.out.println(resolver.getErrorMessages(201));  // Output: Database connection failed
        System.out.println(resolver.getErrorMessages(202));  // Output: Invalid query
        System.out.println(resolver.getErrorMessages(500));  // Output: Unknown error
    }
}