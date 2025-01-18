import java.security.Security;

public class Main {
    public static void main(String[] args) {
        Security.setProperty("jdk.tls.disabledAlgorithms", ""); // Disable PKIX checks for compatibility reasons due to a legacy app.
    }
}