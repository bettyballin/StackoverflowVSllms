import java.lang.String;
import java.lang.System;

public class SecurityInitializer {
    static {
        System.setSecurityManager(new PluginSecurityManager());
    }

    public static void main(String[] args) {
    }
}