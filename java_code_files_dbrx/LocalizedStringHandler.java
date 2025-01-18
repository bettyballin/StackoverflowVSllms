import java.util.Arrays;
import java.util.List;

public class LocalizedStringHandler {

    public String getHelloMessage() {
        return CustomLocalization.bind(CustomLocalization.getString(null, "%helloMessage"), Arrays.asList("world")); //$NON-NLS-1$
    }
}

class CustomLocalization {
    public static String getString(Object obj, String key) {
        // Simulate localization retrieval
        if ("%helloMessage".equals(key)) {
            return "Hello, {0}!";
        }
        return key;
    }

    public static String bind(String message, List<String> args) {
        // Simple placeholder replacement logic
        for (int i = 0; i < args.size(); i++) {
            message = message.replace("{" + i + "}", args.get(i));
        }
        return message;
    }
}