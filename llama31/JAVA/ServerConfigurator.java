import java.lang.String;

public class ServerConfigurator {
    public static void main(String[] args) {
        System.setProperty("java.rmi.server.hostname", "sqlserver.dev.net");
        System.setProperty("jboss.bind.address", "sqlserver.dev.net");
        System.setProperty("jgroups.bind_addr", "sqlserver.dev.net");
    }
}