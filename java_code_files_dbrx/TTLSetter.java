import java.lang.String;

public class TTLSetter {

    byte YOUR_TTL = 64; // your desired value between 0-255

    byte ttl = YOUR_TTL; // your desired value between 0-255, note that it's signed type in packet constructor so be careful with assigning values.

    Packet packet = new Packet();
    byte[] data = new byte[0];
    Group group = new Group();

    {
        packet.setData(data);
        packet.setAddress(group);
        packet.setTrafficClass((ttl << 6) & 0xff);
    }

    public static void main(String[] args) {
    }

    class Packet {
        public void setData(byte[] data) {}
        public void setAddress(Group group) {}
        public void setTrafficClass(int trafficClass) {}
    }

    class Group {}
}