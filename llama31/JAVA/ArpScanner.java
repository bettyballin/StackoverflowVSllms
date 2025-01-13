import java.net.InetAddress;
import jpcap.*;
import jpcap.packet.*;

public class ArpScanner {
    public static void main(String[] args) throws Exception {
        // get a list of all devices on the system
        NetworkInterface[] devices = JpcapCaptor.getDeviceList();

        // open the first device for capturing
        JpcapCaptor captor = JpcapCaptor.openDevice(devices[0], 65535, false, 20);

        // send ARP requests
        for (int i = 1; i <= 254; i++) {
            String ipAddress = "192.168.1." + i;
            ARPPacket arp = new ARPPacket();
            arp.hardtype = ARPPacket.HARDTYPE_ETHER;
            arp.prototype = ARPPacket.PROTOTYPE_IP;
            arp.operation = ARPPacket.ARP_REQUEST;
            arp.hlen = 6;
            arp.plen = 4;
            arp.sender_hardaddr = devices[0].addresses[0].addr;
            arp.sender_protoaddr = devices[0].addresses[0].address.getAddress();
            arp.target_hardaddr = new byte[6];
            arp.target_protoaddr = InetAddress.getByName(ipAddress).getAddress();
            captor.sendPacket(arp);
        }

        // listen for ARP responses
        while (true) {
            Packet packet = captor.getPacket();
            if (packet instanceof ARPPacket) {
                ARPPacket arp = (ARPPacket) packet;
                if (arp.operation == ARPPacket.ARP_REPLY) {
                    System.out.println("Received ARP response from " + InetAddress.getByAddress(arp.sender_protoaddr));
                }
            }
        }
    }
}