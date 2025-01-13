import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SFTPDownload {
    public static void downloadFile(String host, String username, String password, String remotePath, String localPath) {
        JSch jsch = new JSch();
        Session session = null;
        Channel channel = null;
        ChannelSftp sftpChannel = null;

        try {
            session = jsch.getSession(username, host);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            channel = session.openChannel("sftp");
            channel.connect();
            sftpChannel = (ChannelSftp) channel;

            sftpChannel.get(remotePath, localPath);
        } catch (SftpException e) {
            System.out.println("Error downloading file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (sftpChannel != null) {
                sftpChannel.disconnect();
            }
            if (channel != null) {
                channel.disconnect();
            }
            if (session != null) {
                session.disconnect();
            }
        }
    }

    public static void main(String[] args) {
        String host = "yourhost.com";
        String username = "yourusername";
        String password = "yourpassword";
        String remotePath = "/path/to/remote/file.txt";
        String localPath = "/path/to/local/file.txt";

        downloadFile(host, username, password, remotePath, localPath);
    }
}