import org.pcap4j.core.*;
import org.pcap4j.packet.*;
import java.util.*;

public class Main_53 {
    public static void main(String[] args) throws Exception {
        String interfaceName = "\\Device\\NPF_{B68F8CC1-9520-4F7A-AE2A-ECBD4D44C3AF}"; // Adapt to your capture device name
        PcapNetworkInterface networkInterface = Pcaps.findAllDevs()
            .stream()
            .filter(nif -> interfaceName.equals(nif.getName()))
            .findFirst().orElseThrow(() -> new Exception("No such interface: " + interfaceName));
        int snapshotLength = 65536; // In bytes
        int readTimeout = 10; // In milliseconds
        PcapHandle handle = networkInterface.openLive(snapshotLength, PcapNetworkInterface.PromiscuousMode.PROMISCUOUS, readTimeout);
        try {
            while (true) {
                Packet packet = handle.getNextPacketEx();
                if (packet == null) continue;

                final EthernetPacket ethernetPacket = packet.get(EthernetPacket.class);
                System.out.println("src:" + ethernetPacket.getHeader().getSrcAddr()
                                   + " dst:" + ethernetPacket.getHeader().getDstAddr());
            }
        } finally {
            handle.close();
        }
    }
}