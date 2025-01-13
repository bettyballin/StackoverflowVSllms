import javax.comm.*;
import java.util.Enumeration;

public class ListSerialPorts {
    public static void main(String[] args) {
        // Get a list of available ports
        Enumeration<CommPortIdentifier> ports = CommPortIdentifier.getPortIdentifiers();

        // Enumerate the ports
        while (ports.hasMoreElements()) {
            CommPortIdentifier port = ports.nextElement();
            System.out.println(port.getName());
        }
    }
}