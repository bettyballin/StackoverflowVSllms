import java.lang.String;
public class DebugModeChecker {
    boolean isDebugMode = System.getProperty("jpda.listen") != null || System.getenv("DEBUG") != null;
    {
        if (!isDebugMode) {
            // Do something()...
        }
    }
    public static void main(String[] args) {
    }
}