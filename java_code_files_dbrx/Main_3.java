import java.net.*;
import java.util.*;
public class Main_3 {
  public static void main(String[] args) throws Exception {
    Enumeration<NetworkInterface> nifs = NetworkInterface.getNetworkInterfaces();
    while (nifs.hasMoreElements()) {
      NetworkInterface nif = nifs.nextElement();
      System.out.println("\nInterface: " + nif);
      for (InterfaceAddress a : nif.getInterfaceAddresses()) {
        InetAddress address = a.getAddress();
        if (address instanceof Inet4Address) { // IPv4
          System.out.println("  inet " + address);
        } else { // IPv6
          System.out.println("  inet ipv6: [" + address + "]");
        }
      }
    }
  }
}