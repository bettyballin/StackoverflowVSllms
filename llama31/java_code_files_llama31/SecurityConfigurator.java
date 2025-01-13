/*
 * Decompiled with CFR 0.152.
 */
public class SecurityConfigurator {
    public static void main(String[] stringArray) {
    }

    static {
        System.setProperty("javax.net.ssl.socketFactory", "com.example.MyCustomSocketFactory");
    }
}
