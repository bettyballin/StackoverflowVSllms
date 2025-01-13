import java.lang.String;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.xfer.InMemorySourceFile;

public class SSHExample {
    public static void main(String[] args) throws Exception {
        SSHClient ssh = new SSHClient();
        ssh.addHostKeyVerifier((hostname, port, key) -> true); // Verify host key
        ssh.connect("localhost", "username", "password");

        // Execute a command
        String command = "ls -l";
        String result = ssh.runCommand(command).getExitErrorMessage();
        System.out.println(result);

        // Upload a file
        InMemorySourceFile inMemorySourceFile = new InMemorySourceFile();
        inMemorySourceFile.setName("example.txt");
        inMemorySourceFile.setContents("Hello, World!".getBytes());
        ssh.newSCPFileTransfer().upload(inMemorySourceFile, "/remote/path/");

        ssh.disconnect();
    }
}