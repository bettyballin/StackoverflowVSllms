public class RmiClient {
  private String rmiServerAddress;

  public static void main(String[] args) {
    RmiClient client = new RmiClient();

    // If the user passes the RMI server address via command line arguments, use it.
    if (args != null && args.length > 0) {
      client.rmiServerAddress = args[0];
    }

    // Continue with RMI client logic
    // ...
  }
}