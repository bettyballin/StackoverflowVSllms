import java.lang.String;
// Example of using STUN for NAT traversal in Java
import org.xbill.DNS.*;

public class StunExample {
    public static void main(String[] args) throws Exception {
        SimpleResolver resolver = new SimpleResolver("stunserver.org");
        Name name = Name.fromString("_stun._udp.stunserver.org.");
        Record rec = Record.newRecord(name, Type.SRV, DClass.IN);
        Message query = Message.newQuery(rec);
        Message response = resolver.send(query);

        if (response != null) {
            System.out.println("STUN server is available at: " + response);
        }
    }
}