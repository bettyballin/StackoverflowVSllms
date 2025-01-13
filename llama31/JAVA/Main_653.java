import com.jcraft.jsch.*;
import java.io.InputStream;

public class Main_653 {
    public static void main(String[] args) {
        try {
            // Create an SSH session instance
            JSch jsch = new JSch();
            Session session = jsch.getSession("username", "linux-server-ip", 22);

            // Connect to the Linux server
            session.setPassword("password");
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            // Execute the optimizer and receive stdout
            Channel channel = session.openChannel("exec");
            channel.setCommand("java -jar optimizer.jar");
            channel.connect();
            InputStream in = channel.getInputStream();
            StringBuilder output = new StringBuilder();
            int c;
            while ((c = in.read()) != -1) {
                output.append((char) c);
            }
            channel.disconnect();

            // Send the output to the VB6 application over TCP
            // ... (Note: You will need to implement this part yourself)

            session.disconnect();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}