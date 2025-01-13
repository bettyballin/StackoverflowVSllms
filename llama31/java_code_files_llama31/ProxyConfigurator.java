/*
 * Decompiled with CFR 0.152.
 */
public class ProxyConfigurator {
    public static void main(String[] stringArray) {
    }

    static {
        System.setProperty("http.proxyHost", "myproxy.com");
        System.setProperty("http.proxyPort", "9191");
    }
}
