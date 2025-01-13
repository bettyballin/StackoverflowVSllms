import org.apache.commons.net.telnet.TelnetClient;

public class Main_647 {
    public static void main(String[] args) throws Exception {
        TelnetClient client = new TelnetClient();
        client.connect("mud.example.com", 23);
        client.write("login username".getBytes());
        client.write("password password".getBytes());
        System.out.println(client.readAll());
        client.disconnect();
    }
}