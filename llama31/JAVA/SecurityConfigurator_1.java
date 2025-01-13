import java.lang.String;

public class SecurityConfigurator_1_1 {
    static {
        System.setProperty("java.security.policy", "/path/to/my.policy");
    }

    public static void main(String[] args) {
    }
}