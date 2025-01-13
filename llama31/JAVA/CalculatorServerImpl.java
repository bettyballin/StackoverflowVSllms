import java.rmi.Naming;
import java.rmi.RemoteException;

public class CalculatorServerImpl {
    private String mServerName;

    public void exit() throws RemoteException {
        try {
            Naming.unbind(mServerName);
            System.out.println("CalculatorServer exiting.");
        } catch (Exception e) {
            // handle exception
        }

        // Create a new thread to shutdown the RMI server
        Thread shutdownThread = new Thread(new Runnable() {
            public void run() {
                System.exit(1);
            }
        });
        shutdownThread.start();
    }

    public static void main(String[] args) {
    }
}