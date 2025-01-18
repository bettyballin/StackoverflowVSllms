import java.rmi.*;
import java.rmi.registry.*;           // Import the classes necessary for remote method invocation (RMI)
import java.rmi.server.UnicastRemoteObject;

interface MyRemoteInterface extends Remote {
  public String sayHello() throws RemoteException; // Define any remote methods here
}

public class YourApplicationImplementingRemoteInterface extends UnicastRemoteObject implements MyRemoteInterface {
  public YourApplicationImplementingRemoteInterface() throws RemoteException {
    super();
  }

  public static void main(String[] args){              // Remote object's code begins here
    int port = Registry.REGISTRY_PORT;   // default registry port is used for binding
    System.out.println("Starting the RMI server on port " + port);     // Display status and debugging info using print commands
    try {                          // Use try-catch blocks to handle exceptions that can be thrown by remote method invocation(RMI)
      LocateRegistry.createRegistry(port);            // Create a registry at the specified default port

      YourApplicationImplementingRemoteInterface obj = new YourApplicationImplementingRemoteInterface();
      Naming.rebind("rmi://localhost:" + port + "/MyRemoteObjectName", obj); // Bind the remote object in the registry

      System.out.println("Server ready");
    } catch (Exception e) {
      e.printStackTrace();
    } // Handle exception...
  }

  // Implement methods from MyRemoteInterface
  public String sayHello() throws RemoteException {
    return "Hello, world!";
  }
}