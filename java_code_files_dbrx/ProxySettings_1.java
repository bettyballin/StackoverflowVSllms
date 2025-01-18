import java.lang.String;
public class ProxySettings_1 {
    static {
        System.getProperties().put("sun.rmi.transport.proxy.host", "YOUR_PROXY_IP_OR_HOSTNAME");
        System.getProperties().put("sun.rmi.transport.proxy.port", "YOUR_PROXY_PORT (default is 80, you may need to configure your firewall as well)");
    }
    public static void main(String[] args) {
    }
}