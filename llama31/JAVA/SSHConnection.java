import java.lang.String;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SSHConnection {
    public static void main(String[] args) {
        String sshHost = "your-ssh-host";
        String sshUsername = "your-ssh-username";
        String sshPassword = "your-ssh-password";
        String dbHost = "your-db-host";
        String dbUsername = "your-db-username";
        String dbPassword = "your-db-password";

        JSch jsch = new JSch();
        Session session = null;
        try {
            session = jsch.getSession(sshUsername, sshHost, 22);
            session.setPassword(sshPassword);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            int assignedPort = session.setPortForwardingL(0, dbHost, 3306);
            String url = "jdbc:mysql://localhost:" + assignedPort + "/your-db-name";

            Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            // use the connection
        } catch (JSchException | SQLException e) {
            // handle the exception
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.disconnect();
            }
        }
    }
}