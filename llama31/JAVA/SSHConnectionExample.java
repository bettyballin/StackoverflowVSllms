import java.lang.String;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SSHConnectionExample {
    public static void main(String[] args) {
        String hostname = "your-ssh-hostname";
        String username = "your-ssh-username";
        String password = "your-ssh-password";

        JSch jsch = new JSch();
        try {
            Session session = jsch.getSession(username, hostname);
            session.setPassword(password);

            // Avoid asking for key confirmation
            session.setConfig("StrictHostKeyChecking", "no");

            session.connect();

            System.out.println("Connected to " + hostname);

            // Perform your SSH operations here...

            session.disconnect();
        } catch (JSchException e) {
            System.err.println("SSH connection failed: " + e.getMessage());
        }
    }
}