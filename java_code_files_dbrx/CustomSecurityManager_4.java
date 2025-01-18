import java.lang.String;

public class CustomSecurityManager_4 {

    static {
        System.setSecurityManager(new CustomSecurityManager());
    }

    public static void main(String[] args) {
    }
}