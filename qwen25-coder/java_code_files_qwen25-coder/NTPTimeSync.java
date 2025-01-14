import org.apache.commons.net.NTPUDPClient;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;

public class NTPTimeSync {
    public static void main(String[] args) {
        String ntpServer = "pool.ntp.org";
        NTPUDPClient timeClient = new NTPUDPClient();
        try {
            InetAddress inetAddress = InetAddress.getByName(ntpServer);
            timeClient.setDefaultTimeout(10 * 1000); // 10 seconds timeout
            timeClient.open();
            Date date = timeClient.getDate(inetAddress);
            System.out.println("Current (NTP) Time: " + date);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                timeClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}