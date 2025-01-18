import org.snmp4j.TransportMapping;
import org.snmp4j.CommunityTarget;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class SnmpExample {
    public static void main(String[] args) throws Exception {
        // Define the community name and the IP address of your device.
        String comName = "public"; // Default SNMP community string
        String addrs = "192.168.0.10";   // IP Address of my router.
        int SNMPVersion = SnmpConstants.version1;  // Version number used in request packets. Use your own version of SNMP protocol.

        // Create Transport Mapping for sending messages, this message will be sent in the transport layer to destination address, also define port number here as well.
        TransportMapping transport = new DefaultUdpTransportMapping();

        // Create community target which defines where SNMP PDUs are being sent or received from the agent's perspective.
        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString(comName)); // Use the community name defined earlier
        target.setVersion(SNMPVersion);	// Specify SNMP version here
        target.setAddress(new UdpAddress(addrs + "/" + UdpAddress.DEFAULT_PORT));   // Define IP address of target device with default SNMP port
        target.setRetries(2);	// Specify how many times to retry if response not received within timeout
    }
}