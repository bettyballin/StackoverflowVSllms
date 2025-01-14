import com.jcraft.jsch.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class SFTPDownloader {
    public static void main(String[] args) {

        String host = "your.sftp.server.com";
        int port = 22; // default SSH port
        String user = "username";
        String password = "password";
        String remoteFilePath = "/path/to/remote/file.txt";
        String localFilePath = "local/path/to/save/file.txt";

        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);

            // Disable Strict Host Key Checking (for demonstration purposes only)
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;

            // Download file from SFTP server
            File localFile = new File(localFilePath);
            OutputStream outputStream = new FileOutputStream(localFile);
            sftpChannel.get(remoteFilePath, outputStream);

            System.out.println("File has been downloaded successfully.");

            outputStream.close();
            sftpChannel.exit();
            session.disconnect();

        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}