import java.net.InetAddress;
import java.io.IOException;
import org.apache.commons.net.ntp.*;

public class SyncTime {
    public static void main(String[] args) throws Exception {
        // Create an NTP client
        NTPUDPClient client = new NTPUDPClient();
        client.setDefaultTimeout(10000);

        InetAddress hostAddr = InetAddress.getByName("ntp-server-address"); // replace with actual NTP server address

        try {
            System.out.println("Sending request to: " + hostAddr.getHostName());
            client.open();
            TimeInfo info = client.getTime(hostAddr);  // Blocks until response received or timeout occurs.

            // Retrieve timestamps
            long originateTime = info.getOriginateTime();                         // Time at which client sent request
            long receiveTime = info.getReceiveTimeStamp().getTime();              // Time at which server received request
            long transmitTime = info.getTransmitTimeStamp().getTime();            // Time at which server sent response
            long destinationTime = info.getReturnTime();                          // Time at which client received response

            long roundTripDelay = (destinationTime - originateTime) - (transmitTime - receiveTime);
            long localClockOffset = ((receiveTime - originateTime) + (transmitTime - destinationTime)) / 2;

            // Prints the difference between local and synchronization network time.
            System.out.println("Network time offset is " + localClockOffset + " ms");
        } catch (IOException exc) {
            throw new Exception("I/O error: " + exc);
        } finally {
            client.close();
        }
    }
}