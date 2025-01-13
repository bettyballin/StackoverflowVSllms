/*
 * Decompiled with CFR 0.152.
 */
public class OracleEnvironmentConfigurator {
    public static void main(String[] stringArray) {
    }

    static {
        System.setProperty("java.library.path", System.getProperty("java.library.path") + ";" + System.getenv("ORACLE_HOME") + "\\bin");
    }
}
