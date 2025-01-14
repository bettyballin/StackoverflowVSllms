import java.lang.String;
import org.jnetpcap.Pcap;
import org.jnetpcap.packet.JBuffer;
import org.jnetpcap.packet.JPacket;
import org.jnetpcap.packet.PcapPacketHandler;
import org.jnetpcap.protocol.network.Arp;

public class ArpScanner {

    public static void main(String[] args) {
        StringBuilder errbuf = new StringBuilder(); // For any error msgs
        Pcap pcap = Pcap.openLive("eth0", 64 * 1024, // snaplen in bytes 
                                   true,           // promiscuous mode
                                   10 * 1000,      // timeout in ms,
                                   errbuf); 

        if (pcap == null) {
            System.err.printf("Error while opening device for capture: %s\n",
                              errbuf.toString());
            return;
        }

        PcapPacketHandler<String> jpacketHandler = new PcapPacketHandler<String>() {

            public void nextPacket(JPacket packet, String user) {
                Arp arp = new Arp();
                if (packet.hasHeader(arp)) {
                    System.out.println("ARP: " + 
                                       arp.toString());
                    // Extract MAC & IP information from the ARP packets for your purpose.
                }
            }
        };

        pcap.loop(Pcap.LOOP_INFINITE, jpacketHandler, "jNetPcap岩石");

        pcap.close();
    }
}