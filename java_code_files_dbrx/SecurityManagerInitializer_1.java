import java.lang.String;
public class SecurityManagerInitializer_1 {
    static {
        System.setSecurityManager(new CustomSecurityManager());
    }
    public static void main(String[] args) {
    }
}