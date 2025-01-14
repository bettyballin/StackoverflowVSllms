import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

// Define the interfaces
interface AInterface extends Remote {
    void methodA() throws RemoteException;
    void setB(BInterface b) throws RemoteException;
}

interface BInterface extends Remote {
    void methodB() throws RemoteException;
    void setA(AInterface a) throws RemoteException;
}

// Implement A and B
class A extends UnicastRemoteObject implements AInterface {

    private BInterface b;

    public A() throws RemoteException {
        super();
    }

    @Override
    public void methodA() throws RemoteException {
        System.out.println("A's methodA called.");
        // Call B's methodB
        if (b != null) {
            b.methodB();
        }
    }

    @Override
    public void setB(BInterface b) throws RemoteException {
        this.b = b;
    }
}

class B extends UnicastRemoteObject implements BInterface {

    private AInterface a;

    public B() throws RemoteException {
        super();
    }

    @Override
    public void methodB() throws RemoteException {
        System.out.println("B's methodB called.");
        // Optionally, call back to A's method if needed
        // if (a != null) {
        //     a.methodA();
        // }
    }

    @Override
    public void setA(AInterface a) throws RemoteException {
        this.a = a;
    }
}

// RMIServer class
public class RMIServer {
    public static void main(String[] args) {
        try {
            // Create instances of A and B
            A a = new A();
            B b = new B();

            // Set up the relationship (A needs to know about B, and B needs to know about A)
            a.setB(b);
            b.setA(a);

            // Register A and B in the RMI registry
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("aInstance", a);
            registry.rebind("bInstance", b);

            System.out.println("RMIServer is running...");
        } catch (Exception e) {
            System.err.println("RMIServer exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

// RMIClient class
class RMIClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(null, 1099);
            AInterface aInstance = (AInterface) registry.lookup("aInstance");

            // Call methodA on A
            aInstance.methodA();
        } catch (Exception e) {
            System.err.println("RMIClient exception: " + e.toString());
            e.printStackTrace();
        }
    }
}