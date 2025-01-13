public class RmiServerAddressChecker {
    public static void main(String[] args) {
        String rmiServerAddress = System.getProperty("rmi.server.address");
        if (rmiServerAddress == null || rmiServerAddress.isEmpty()) {
            // Handle the case where the property is not set or empty
            System.err.println("RMI server address is not provided.");
            System.exit(1); // or handle appropriately
        }
        // Use the rmiServerAddress to connect to your RMI server
    }
}