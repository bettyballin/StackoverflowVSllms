import java.lang.ref.Cleaner;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteObject extends UnicastRemoteObject implements MyRemoteInterface {
    // implementation details omitted
    public MyRemoteObject() throws RemoteException {
        super();
    }
}

interface MyRemoteInterface {
    // methods omitted
}

class MyGarbageCollector {
    private MyRemoteObject myRemote;

    public MyGarbageCollector(MyRemoteObject myRemote) {
        this.myRemote = myRemote;
        Cleaner cleaner = Cleaner.create(); // Singleton, safe to keep a reference
        cleaner.register(this, new Runnable() { 
            @Override public void run() { 
                // perform cleanup actions 
            }
        });
    }
}