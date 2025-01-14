public class ConfigureCluster {
    public static void main(String[] args) {
        try {
            // Initialize the cluster settings
            Cluster.createCluster("MyCluster", "Server1,Server2,Server3");
            System.out.println("Cluster created successfully!");
            
            // Optionally, configure other cluster properties here
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}

class Cluster {
    public static void createCluster(String clusterName, String servers) throws ServiceException {
        // Minimal implementation to allow compilation
        // In a real scenario, this would set up the cluster
        System.out.println("Creating cluster " + clusterName + " with servers " + servers);
    }
}

class ServiceException extends Exception {
    public ServiceException() {
        super();
    }
    
    public ServiceException(String message) {
        super(message);
    }
    
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public ServiceException(Throwable cause) {
        super(cause);
    }
}