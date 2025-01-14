import com.jcraft.jsch.*;
import java.io.InputStream;
import java.util.Properties;

public class SSHConnectionExample {
    public static void main(String[] args) {
        String host = "your_host";
        int port = 22;
        String user = "your_username";
        String password = "your_password";

        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            // Set the password for authentication
            session.setPassword(password);

            // Disable StrictHostKeyChecking to avoid unknown host key warning.
            // In production, you should handle key verification properly.
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            session.connect();
            System.out.println("Connected to the SSH server.");

            // Example of executing a command remotely
            Channel channel = session.openChannel("exec");
            ((ChannelExec)channel).setCommand("ls -l");

            channel.setInputStream(null);
            ((ChannelExec)channel).setErrStream(System.err);

            InputStream in = channel.getInputStream();
            channel.connect();

            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) break;
                    System.out.print(new String(tmp, 0, i));
                }
                if (channel.isClosed()) {
                    if (in.available() > 0) continue;
                    System.out.println("exit-status: " + channel.getExitStatus());
                    break;
                }
                try { Thread.sleep(1000); } catch (Exception ee) {}
            }

            channel.disconnect();
            session.disconnect();

        } catch (Exception e) {
            System.err.print("Error connecting to the server: " + e);
        }
    }
}