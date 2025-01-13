import java.lang.String;

public class ProxyConfigurator_5_5 {
    // Burp Suite configuration to set up port redirection
    public static void main(String[] args) {
        // Assuming proxy is an instance of a class that has setListenAddress and setTargetAddress methods
        // For demonstration purposes, let's assume it's a custom class called Proxy
        Proxy proxy = new Proxy();
        proxy.setListenAddress("localhost", 8080);
        proxy.setTargetAddress("localhost", 80);
    }
}

// For the sake of completeness, let's define a simple Proxy class
class Proxy {
    public void setListenAddress(String address, int port) {
        System.out.println("Listen address set to " + address + ":" + port);
    }

    public void setTargetAddress(String address, int port) {
        System.out.println("Target address set to " + address + ":" + port);
    }
}