import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class Main_75 {
    public static void main(String[] args) {
        // Create an SSH session
        JSch jsch = new JSch();
        Session session = jsch.getSession("your_username", "your_ssh_host", 22);
        session.setPassword("your_password");
        session.setConfig("StrictHostKeyChecking", "no");
        try {
            session.connect();
        } catch (Exception e) {
            System.out.println("Error connecting to SSH session: " + e.getMessage());
            return;
        }

        // Create a tunnel
        int localPort = 1433; // or any available port
        try {
            session.setPortForwardingL("localhost", localPort, "your_database_host", 1433);
        } catch (Exception e) {
            System.out.println("Error creating tunnel: " + e.getMessage());
            return;
        }

        // Use the tunneled connection
        String url = "jdbc:sqlserver://localhost:" + localPort + ";databaseName=your_database";
        System.out.println("Tunneled connection URL: " + url);
    }
}