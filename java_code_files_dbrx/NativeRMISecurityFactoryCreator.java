import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class NativeRMISecurityFactoryCreator {
    String user = "my_user";
    NativeRMISecurityFactory factory = new NativeRMISecurityFactory(user);

    public NativeRMISecurityFactoryCreator() {
        LocateRegistry.createRegistry(1099, null, factory).getRegistry();
        Naming.rebind("HelloObj", new HelloInterfaceImpl(), factory);
    }

    public static void main(String[] args) {
        new NativeRMISecurityFactoryCreator();
    }
}