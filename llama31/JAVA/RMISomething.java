import java.lang.String;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;

public class RMISomething {
  public static String getSomething() throws ServerNotActiveException {
    return RemoteServer.getClientHost();
  }

	public static void main(String[] args) {
	}
}