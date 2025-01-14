import java.rmi.Remote;
import java.rmi.RemoteException;

public class MyBCRmiInterfaceImpl {
   public interface MyBCRmiInterface extends Remote {
       String myRemoteMethod(String param) throws RemoteException;
   }

   public static void main(String[] args) {
   }
}