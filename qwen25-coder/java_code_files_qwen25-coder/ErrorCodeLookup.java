import java.util.HashMap;
import java.util.Map;

public class ErrorCodeLookup {
    private Map<String, String> errorCodes = new HashMap<>();

    public ErrorCodeLookup() {
        initializeErrorCodes();
    }

    private void initializeErrorCodes() {
        errorCodes.put("A01", "whatever error");
        errorCodes.put("U01", "another error");
        errorCodes.put("U02", "yet another error type");
    }

    public String getErrorMessage(String errorCode) {
        return errorCodes.getOrDefault(errorCode, "Unknown Error Code");
    }

    public static void main(String[] args) {
    }
}