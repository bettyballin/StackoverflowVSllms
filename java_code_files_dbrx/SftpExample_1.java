import com.jcraft.jsch.*;
import java.util.Vector;
import java.util.ArrayList;
import java.util.List;

public class SftpExample {
    private static void scp(String host) throws JSchException, SftpException {
        // Initialize a new session with the remote user and server details
        Session session = new JSch().getSession("your_username", host);
        session.setPassword("your_password");
        session.setConfig("StrictHostKeyChecking", "no"); // Add this to avoid UnknownHostKey issue
        session.connect();

        Channel channel = session.openChannel("sftp");
        channel.connect();

        // Create an SFTP client object to list files/directories from the remote server
        ChannelSftp sftpClient = (ChannelSftp) channel;
        try {
            Vector<ChannelSftp.LsEntry> list = sftpClient.ls("./*");
            List<String> filenames = new ArrayList<>();
            for (ChannelSftp.LsEntry entry : list) {
                filenames.add(entry.getFilename());
            }
            System.out.println(String.join("\n", filenames));
        } finally {
            // Close all connections
            sftpClient.disconnect();
            session.disconnect();
        }
    }
}