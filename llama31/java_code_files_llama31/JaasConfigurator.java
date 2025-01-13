/*
 * Decompiled with CFR 0.152.
 */
public class JaasConfigurator {
    public static void main(String[] stringArray) {
    }

    static {
        System.setProperty("java.security.auth.login.config", "/path/to/your/jaas.conf");
    }
}
