import spread.*;
import java.net.InetAddress;

public class SpreadClient {
    public static void main(String[] args) throws Exception {
        SpreadConnection sc = new SpreadConnection();
        SpreadGroup sg = new SpreadGroup();

        try {
            sc.connect(InetAddress.getByName("192.168.1.2"), 4803, "TestGroupName", false, true);
            sg.join(sc, "test");

            while (!Thread.currentThread().isInterrupted()) {
                SpreadMessage msg = sc.receive();
                System.out.println("Received: " + new String(msg.getData()));
            }
        } finally {
            try {
                sg.leave();
                sc.disconnect();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}