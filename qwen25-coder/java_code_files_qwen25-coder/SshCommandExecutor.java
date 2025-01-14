import com.jcraft.jsch.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class SshCommandExecutor {
    public static void main(String[] args) {
        String host = "your.remote.host";
        int port = 22;
        String user = "username";
        String password = "password";
        String command = "ls -la";

        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);

            // Set up the session to automatically accept unknown host keys
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            // Establish the connection
            session.connect();

            // Open a channel and connect it to the SSH server
            Channel channel = session.openChannel("exec");
            ((ChannelExec)channel).setCommand(command);
            
            // Set up input/output streams
            channel.setInputStream(null);
            OutputStream out = channel.getOutputStream();
            InputStream in = channel.getInputStream();

            // Connect the channel
            channel.connect();

            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) break;
                    System.out.print(new String(tmp, 0, i));
                }
                if (channel.isClosed()) {
                    System.out.println("exit-status: " + channel.getExitStatus());
                    break;
                }
                try { Thread.sleep(1000); } catch (Exception ee){};
            }

            // Close the streams and session
            channel.disconnect();
            session.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}