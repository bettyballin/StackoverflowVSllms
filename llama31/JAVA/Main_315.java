import org.snmp4j.CommunityTarget;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericManagedObject;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.snmp4j.PDU;

public class Main_315 {
    public static void main(String[] args) throws Exception {
        // Create the target address
        Address targetAddress = GenericManagedObject.createAddress("udp:localhost/161");

        // Create the community target
        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString("public"));
        target.setAddress(targetAddress);
        target.setRetries(2); // added to avoid warnings
        target.setTimeout(5000); // added to avoid warnings
        target.setVersion(SnmpConstants.version2c); // added to avoid warnings

        // Create the SNMP object
        TransportMapping transport = new DefaultUdpTransportMapping();
        Snmp snmp = new Snmp(transport);

        // Open the transport
        transport.listen();

        // Create the PDU
        PDU pdu = new PDU();
        pdu.setType(PDU.GET);
        OID oid = new OID(".1.3.6.1.2.1.1.1.0"); // example OID
        pdu.add(new VariableBinding(oid));

        // Send the request
        ResponseEvent response = snmp.send(pdu, target);

        // Process the response
        if (response.getResponse() != null) {
            PDU responsePDU = response.getResponse();
            System.out.println("Received response:");
            for (VariableBinding vb : responsePDU.getVariableBindings()) {
                System.out.println(vb.toString());
            }
        } else {
            System.out.println("No response received");
        }

        // Close the SNMP object
        snmp.close();
    }
}