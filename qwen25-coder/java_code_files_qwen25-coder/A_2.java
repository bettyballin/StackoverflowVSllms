// AInterface.java
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AInterface extends Remote {
    void methodA() throws RemoteException;
}

// BInterface.java
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BInterface extends Remote {
    void methodB() throws RemoteException;
}

// A.java
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class A extends UnicastRemoteObject implements AInterface {
    private BInterface bInstance;

    protected A() throws RemoteException {
        super();
    }

    public void setB(BInterface b) {
        this.bInstance = b;
    }

    @Override
    public void methodA() throws RemoteException {
        System.out.println("Method A called");
        // Call back to B if needed
        if (bInstance != null) {
            bInstance.methodB();
        }
    }
}

// B.java
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class B extends UnicastRemoteObject implements BInterface {
    private AInterface aInstance;

    protected B() throws RemoteException {
        super();
    }

    public void setA(AInterface a) {
        this.aInstance = a;
    }

    @Override
    public void methodB() throws RemoteException {
        System.out.println("Method B called");
        // Call back to A if needed
        if (aInstance != null) {
            aInstance.methodA();
        }
    }
}