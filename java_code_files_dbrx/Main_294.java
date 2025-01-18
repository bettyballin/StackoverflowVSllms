import org.jnetpcap.Pcap;
import org.jnetpcap.packet.*;
import org.jnetpcap.packet.format.FormatUtils;
import org.jnetpcap.protocol.network.Arp;
import org.jnetpcap.protocol.network.Ethernet;

public class Main_294 {
    public static void main(String[] args) {
        try {
            StringBuilder errbuf = new StringBuilder(); // for any error msgs
            String device = "wlan0"; // your network interface name goes here, use ipconfig or ifconfig to get it

            int snaplen = 64 * 1024; // Capture all packets, no truncation
            int flags = Pcap.MODE_PROMISCUOUS; // capture all packets
            int timeout = 10 * 1000; // ms

            // Open the device for live capture
            Pcap pcap = Pcap.openLive(device, snaplen, flags, timeout, errbuf);
            if (pcap == null) {
                System.err.printf("Error while opening device for capture: " + errbuf.toString());
                return;
            }

            // Now we're capturing
            PcapPacket packet = new PcapPacket(JMemory.POINTER);

            while (pcap.nextEx(packet) == Pcap.NEXT_EX_OK) {
                if (packet == null)
                    continue; // empty packet, no point even looking at it
                Ethernet ethernet = new Ethernet();
                Arp arp = new Arp();
                if (packet.hasHeader(ethernet)) { // grab the ethernet header now
                    if (packet.hasHeader(arp)) { // does it also have an ARP header?
                        System.out.println("Source: " + FormatUtils.ip(arp.spa()));
                    } else { // Nope, we don't want any of these packets!
                        continue;
                    }
                }
            }

            pcap.close();

        } catch (Exception e) { // handle your exceptions here!
            System.out.println("Error: " + e);
        } // end main()
    } // end Main class
} // end example program