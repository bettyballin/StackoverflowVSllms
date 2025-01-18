import java.util.Map;
import java.util.HashMap;

public class ErrorManager {
    Map<String, String> errorMap = new HashMap<>();

    public ErrorManager() {
        errorMap.put("A01", "whatever error");
        errorMap.put("U01", "another error");
        errorMap.put("U02", "yet another error type");
    }

    public String getErrorMessage(String code) {
        return errorMap.getOrDefault(code, "Unknown Error Code");
    }
}