/*
 * Decompiled with CFR 0.152.
 */
import java.util.Map;

public class ErrorMessageMapper {
    private static final Map<Integer, String> ERROR_MESSAGES = Map.of(101, "Invalid username", 102, "Invalid password", 201, "Database connection failed", 202, "Invalid query");

    public String getErrorMessages(int n) {
        return ERROR_MESSAGES.getOrDefault(n, "Unknown error");
    }

    public static void main(String[] stringArray) {
        ErrorMessageMapper errorMessageMapper = new ErrorMessageMapper();
        System.out.println(errorMessageMapper.getErrorMessages(101));
        System.out.println(errorMessageMapper.getErrorMessages(102));
        System.out.println(errorMessageMapper.getErrorMessages(201));
        System.out.println(errorMessageMapper.getErrorMessages(202));
        System.out.println(errorMessageMapper.getErrorMessages(500));
    }
}
