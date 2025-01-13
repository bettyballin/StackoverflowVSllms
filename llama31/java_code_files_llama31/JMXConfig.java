/*
 * Decompiled with CFR 0.152.
 */
public class JMXConfig {
    public static void main(String[] stringArray) {
        System.setProperty("com.sun.management.jmxremote", "");
        System.setProperty("com.sun.management.jmxremote.port", "1099");
        System.setProperty("com.sun.management.jmxremote.ssl", "false");
        System.setProperty("com.sun.management.jmxremote.authenticate", "false");
    }
}
