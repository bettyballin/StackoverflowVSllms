import java.io.IOException;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class MulticastSender {
    private final static String IP_ADDR   = "230.1.1.1"; // The destination multicast address
    private final static int PORT         = 8989;        // The destination port
    public static void main(String[] args){
      try {
        // Open a network socket and join the multicast group ...
        DatagramChannel chan = DatagramChannel.open();
        chan.setOption(StandardSocketOptions.SO_REUSEADDR, true);
        chan.socket().bind(new InetSocketAddress(PORT));
        InetAddress group = InetAddress.getByName(IP_ADDR); // create a multicast address object
        NetworkInterface intf = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
        // Join the group
        MembershipKey key = chan.join(group, intf);  // Receiver joins the group with a given Multicast address (IP_ADDR / PORT here) and on a specified network interface
        ByteBuffer buf;
        do {
          Thread.sleep(2000);
          String message = System.currentTimeMillis() + " " + (int)(Math.random() * 10);
          // some simple payload data, appending the current timestamp and a random number
          buf = Charset.forName("US-ASCII").encode(message);
          SocketAddress target = new InetSocketAddress(IP_ADDR, PORT);
          chan.send(buf, target);   // Send message on regular intervals
        } while(!Thread.currentThread().isInterrupted());
        System.exit(0);               // Leave group and close channel when we interrupt the program
      } catch(Exception e){
        System.out.println("Sender Error: "+e);
        e.printStackTrace();
      }
    }
}