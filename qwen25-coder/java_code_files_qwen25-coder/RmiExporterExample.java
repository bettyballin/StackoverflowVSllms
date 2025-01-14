public class RmiExporterExample {
    
    public static void main(String[] args) {
        // Replace YourServiceInterface with the actual interface your service implements
        YourServiceInterface yourServiceBean = new YourServiceImplementation();

        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setService(yourServiceBean);
        exporter.setServiceName("YourService");
        exporter.setRegistryHost("192.168.1.100"); // New IP address
        exporter.setRegistryPort(1099); // Ensure the correct port is used
    }
}

// Dummy interface and implementation for compilation purposes
interface YourServiceInterface {
    // Define service methods here
}

class YourServiceImplementation implements YourServiceInterface {
    // Implement service methods here
}

// Minimal implementation of RmiServiceExporter for compilation purposes
class RmiServiceExporter {
    public void setService(Object service) {
        // Implementation here
    }
    public void setServiceName(String name) {
        // Implementation here
    }
    public void setRegistryHost(String host) {
        // Implementation here
    }
    public void setRegistryPort(int port) {
        // Implementation here
    }
}