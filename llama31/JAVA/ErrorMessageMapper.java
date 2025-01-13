import java.lang.String;
import java.util.Map;

public class ErrorMessageMapper {
    private static final Map<Integer, String> ERROR_MESSAGES = Map.of(
        101, "Invalid username",
        102, "Invalid password",
        201, "Database connection failed",
        202, "Invalid query"
    );

    public String getErrorMessages(int code) {
        return ERROR_MESSAGES.getOrDefault(code, "Unknown error");
    }

    public static void main(String[] args) {
        ErrorMessageMapper mapper = new ErrorMessageMapper();
        System.out.println(mapper.getErrorMessages(101)); // prints: Invalid username
        System.out.println(mapper.getErrorMessages(102)); // prints: Invalid password
        System.out.println(mapper.getErrorMessages(201)); // prints: Database connection failed
        System.out.println(mapper.getErrorMessages(202)); // prints: Invalid query
        System.out.println(mapper.getErrorMessages(500)); // prints: Unknown error
    }
}