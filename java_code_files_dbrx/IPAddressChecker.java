import java.net.*;
import java.util.regex.*;

public class IPAddressChecker {
    public boolean isIPorHost(String input) {
        // pattern for a typical IPv4 address (assuming no leading zeros in parts of the IPs).
        String ipPattern = "((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}" +
                           "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
        // pattern for a typical hostname (assuming there are no special characters)
        String hostPattern = "^((?!-)[A-Za-z0-9-]{0,63}(?<!-)\\.)*[A-Za-z]{2,}$";

        boolean isIP = input.matches(ipPattern);
        if (!isIP) { // If this isn't an IP address then check if it's a hostname
            Pattern pattern = Pattern.compile(hostPattern);
            Matcher matcher = pattern.matcher(input);
            return matcher.find();
        }
        return true;
    }
}