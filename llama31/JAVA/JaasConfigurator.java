import java.lang.System;

public class JaasConfigurator {
    static {
        System.setProperty("java.security.auth.login.config", "/path/to/your/jaas.conf");
    }

    public static void main(String[] args) {
    }
}