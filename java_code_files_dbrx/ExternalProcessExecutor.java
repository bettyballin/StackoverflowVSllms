import java.lang.String;
public class ExternalProcessExecutor {
    static {
        try {
            Runtime.getRuntime().exec("true");
        } catch (SecurityException ex) {
            // Not enough permissions to execute external processes
        }
    }

    public static void main(String[] args) {
    }
}