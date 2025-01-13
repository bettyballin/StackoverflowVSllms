/*
 * Decompiled with CFR 0.152.
 */
public class ServerConfigurator {
    public static void main(String[] stringArray) {
        System.setProperty("java.rmi.server.hostname", "sqlserver.dev.net");
        System.setProperty("jboss.bind.address", "sqlserver.dev.net");
        System.setProperty("jgroups.bind_addr", "sqlserver.dev.net");
    }
}
