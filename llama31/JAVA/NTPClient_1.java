import java.lang.String;
import org.apache.commons.net.ntp.NTPUDPClient;

public class NTPClient_1_1 {
    public static void main(String[] args) throws Exception {
        NTPUDPClient client = new NTPUDPClient();
        client.setDefaultPort(123);
        client.open();

        String server = "pool.ntp.org";
        long timestamp = client.getTime(server).toMillis();

        System.out.println("Current time: " + timestamp);
    }
}