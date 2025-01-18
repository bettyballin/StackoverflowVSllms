import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.ChannelExec;

import java.util.Properties;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class SshSession {
    public static void main(String[] args) throws Exception {
        String host = "example.com"; // Server's IP address or name
        String user = "username"; // Your username on server
        int port = 22; // Remote machine's SSH port number (usually 22)
        String password = "password"; // Your plaintext password, not secure! Better to use keys instead.

        JSch jsch = new JSch();
        Session session = jsch.getSession(user, host, port);
        session.setPassword(password);

        Properties properties = new Properties();
        properties.put("StrictHostKeyChecking", "no"); // For first connection (you may want to configure StrictHostKeyChecking properly in production)
        session.setConfig(properties);

        try {
            session.connect(); // Establish the SSH connection
            ChannelExec channel = (ChannelExec) session.openChannel("exec");
            String command = "ls -l"; // The remote machine's command you want to run
            ((ChannelExec)channel).setCommand(command);
            channel.connect();
            InputStream input = channel.getInputStream(); // Get response from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line); // Printing out the output of your command
            }
        } catch (Exception e) {
            throw new RuntimeException("Error: unable to establish SSH connection", e);
        } finally {
            session.disconnect(); // Always remember to close connections when done!
        }
    }
}