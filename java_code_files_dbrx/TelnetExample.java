import org.apache.commons.net.telnet.TelnetClient;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TelnetExample {
    public static void main(String[] args) {
        try {
            TelnetClient telnet = new TelnetClient();
            telnet.connect("localhost", 23);    // assuming the MUD is hosted locally at port 23
            PrintWriter out = new PrintWriter(telnet.getOutputStream(), true);
            out.println("");    // send data to the server using println()
            BufferedReader in = new BufferedReader(new InputStreamReader(telnet.getInputStream()));
            String line = in.readLine();    // read response from the server
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}