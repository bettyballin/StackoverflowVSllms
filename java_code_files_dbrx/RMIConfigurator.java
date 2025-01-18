import java.lang.String;
public class RMIConfigurator {
    static {
        System.setProperty("java.rmi.server.hostname", "[new IP address]");
        System.setProperty("java.rmi.server.logCalls", "true");
    }
    public static void main(String[] args) {
    }
}