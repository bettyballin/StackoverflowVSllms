import java.lang.String;

public class RmiConfigurator {
    static {
        System.setProperty("java.rmi.server.hostname", "server_hostname");
    }

    public static void main(String[] args) {
    }
}