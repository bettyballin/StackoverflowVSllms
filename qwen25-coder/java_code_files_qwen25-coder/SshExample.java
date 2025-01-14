import org.apache.sshd.client.SshClient;
import org.apache.sshd.client.channel.ChannelExec;
import org.apache.sshd.client.channel.ClientChannelEvent;
import org.apache.sshd.client.session.ClientSession;
import java.util.Collections;

public class SshExample {
    public static void main(String[] args) throws Exception {
        SshClient sshClient = SshClient.setUpDefaultClient();
        sshClient.start();

        try (ClientSession session = sshClient.connect("username", "hostname", 22).verify().getSession()) {
            session.addPasswordIdentity("password");
            session.auth().verify();

            // Execute a command
            try (ChannelExec channel = session.createExecChannel("your-command-here")) {
                channel.setOut(System.out);
                channel.open().verify();
                channel.waitFor(Collections.singleton(ClientChannelEvent.CLOSED), 0);
                System.out.println("Exit code: " + channel.getExitStatus());
            }
        } finally {
            sshClient.stop();
        }
    }
}