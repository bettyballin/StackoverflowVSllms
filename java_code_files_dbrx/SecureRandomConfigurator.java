import java.lang.String;
public class SecureRandomConfigurator {
    static {
        System.setProperty("securerandom.source", "file:///dev/urandom");
    }
    public static void main(String[] args) {
    }
}