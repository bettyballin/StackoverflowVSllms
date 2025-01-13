import java.lang.String;

public interface Network {
  void connect();
}

class Firewall implements Network {
  private Network network;

  public Firewall(Network network) {
    this.network = network;
  }

  @Override
  public void connect() {
    if (allowAccess()) {
      network.connect();
    } else {
      System.out.println("Access denied.");
    }
  }

  private boolean allowAccess() {
    // implement access control logic
    return true;
  }
}

class Internet implements Network {
  @Override
  public void connect() {
    System.out.println("Connecting to the internet.");
  }
}

public class Main {
  public static void main(String[] args) {
    Network internet = new Internet();
    Network firewall = new Firewall(internet);
    firewall.connect();
  }
}