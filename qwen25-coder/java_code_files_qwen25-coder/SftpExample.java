import org.apache.sshd.client.SshClient;
import org.apache.sshd.client.session.ClientSession;
import org.apache.sshd.client.subsystem.sftp.SftpClient;

public class SftpExample {
    public static void main(String[] args) throws Exception {
        SshClient sshClient = SshClient.setUpDefaultClient();
        sshClient.start();

        try (ClientSession session = sshClient.connect("username", "hostname", 22).verify().getSession()) {
            session.addPasswordIdentity("password");
            session.auth().verify();

            // Use SFTP for file transfer
            try (SftpClient sftp = session.createSftpClient()) {
                sftp.get("/remote/file/path", "/local/file/path");
                System.out.println("File downloaded successfully.");
            }
        } finally {
            sshClient.stop();
        }
    }
}