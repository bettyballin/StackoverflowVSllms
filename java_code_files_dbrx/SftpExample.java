import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.userauth.keyprovider.KeyProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class SftpExample {
    public static void main(String[] args) throws Exception {
        // create new ssh client with the default settings of 'net.schmizz'
        final SSHClient ssh = new SSHClient();
        try {
            ssh.addHostKeyVerifier("example.com", "ssh-ed25519", "[base64 encoded fingerprint]"); // replace this with your own hostkey verification logic
            ssh.connect("example.com");
            try {
                ssh.authPublickey(System.getProperty("user.name"), getPrivateKey(ssh));
                final SFTPClient ftp = ssh.newSFTPClient();
                File localFile = new File("/path/to/localfile"); // change this to wherever you want the file on your machine
                if (localFile.exists()) {
                    System.out.println("The file exists already.");
                } else {
                    try (FileOutputStream fos = new FileOutputStream(localFile)) {
                        ftp.get("/path/to/remote-file", fos); // replace '/path/to/remote-file' with the path to your remote file
                        System.out.println("The file is fetched.");
                    }
                }
            } finally {
                ssh.disconnect();
            }
        } finally {
            ssh.close();
        }
    }

    private static KeyProvider getPrivateKey(SSHClient ssh) throws IOException {
        // Implement this method to return the KeyProvider for your private key
        return ssh.loadKeys("/path/to/privatekey"); // Replace with your private key path
    }
}