import java.lang.String;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class RealIpDetector {
    public String getRealIp() {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            return addr.getHostAddress();
        } catch (UnknownHostException e) {
            return null;
        }
    }

	public static void main(String[] args) {
	}
}