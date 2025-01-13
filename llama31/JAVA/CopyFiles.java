import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class CopyFiles {
    public static void main(String[] args) {
        String localFile = "/path/to/local/file.txt";
        String remoteFile = "/path/to/remote/file.txt";
        String remoteHost = "remote-machine-ip";
        String username = "your-username";
        String password = "your-password";

        JSch jsch = new JSch();
        Session session = null;
        ChannelSftp sftpChannel = null;

        try {
            session = jsch.getSession(username, remoteHost, 22);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();

            sftpChannel.put(localFile, remoteFile);
        } catch (SftpException e) {
            System.err.println("Error copying file: " + e.getMessage());
        } finally {
            if (sftpChannel != null) {
                sftpChannel.disconnect();
            }
            if (session != null) {
                session.disconnect();
            }
        }
    }
}