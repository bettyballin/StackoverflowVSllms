/*
 * Decompiled with CFR 0.152.
 */
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiClient {
    public static void main(String[] stringArray) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        Remote remote = registry.lookup("your-rmi-object-name");
        YourRmiObject yourRmiObject = (YourRmiObject)remote;
        String string = yourRmiObject.yourRmiMethod();
        System.out.println(string);
    }
}
