import java.rmi.*;
import java.rmi.server.*;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {
    private String mServerName;

    public CalculatorImpl(String serverName) throws RemoteException {
        super();
        mServerName = serverName;
    }

    public int calculate(int op1, int op2) throws RemoteException {
        return op1 + op2;
    }

    public void exit() throws RemoteException {
        try {
            Naming.unbind(mServerName);
            System.out.println("CalculatorServer exiting.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Use a separate thread to allow the response to be sent before exiting
        new Thread(() -> {
            try {
                Thread.sleep(100); // short delay to let the response be sent
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            System.exit(1);
        }).start();
    }

    public static void main(String args[]) throws Exception {
        System.out.println("Initializing CalculatorServer.");

        String serverObjName = "rmi://localhost/Calculator";

        Calculator calc = new CalculatorImpl(serverObjName);

        Naming.rebind(serverObjName, calc);

        System.out.println("CalculatorServer running.");
    }
}