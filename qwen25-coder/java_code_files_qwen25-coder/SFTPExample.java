// Example of using JSch library for SFTP in Java
import com.jcraft.jsch.*;

public class SFTPExample {
    public static void main(String[] args) {
        String host = "your_host";
        int port = 22;
        String user = "username";
        String password = "password";

        JSch jsch = new JSch();
        Session session = null;
        ChannelSftp channelSftp = null;
        try {
            session = jsch.getSession(user, host, port);

            session.setPassword(password);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();

            channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();
            // SFTP operations go here

        } catch (JSchException | SftpException e) {
            e.printStackTrace();
        } finally {
            if (channelSftp != null && channelSftp.isConnected()) {
                channelSftp.disconnect();
                channelSftp.exit();
            }
            if (session != null && session.isConnected()) {
                session.disconnect();
            }
        }
    }
}