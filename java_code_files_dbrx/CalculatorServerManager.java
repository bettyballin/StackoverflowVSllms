import java.rmi.Naming;
import java.rmi.RemoteException;

public class CalculatorServerManager {
    public void secureExit(String name) throws RemoteException {
        try {
            Naming.unbind("//localhost/" + name); // replace "name" with the actual server name if it is static, or use a dynamic value here
            System.out.println("CalculatorServer exiting gracefully.");
        } catch(Exception e) {
            // Handle exception as needed
        }
    }
    public static void main(String[] args) {
    }
}