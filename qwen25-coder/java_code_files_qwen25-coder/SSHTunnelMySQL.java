import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SSHTunnelMySQL {
    public static void main(String[] args) {
        String host = "ssh.server.com";
        int hostPort = 22;
        String userSSH = "yourUsername";
        String passwordSSH = "yourPassword";

        String hostDatabase = "localhost";
        int portDatabase = 3307; // Local port to bind to
        String remoteHostDatabase = "127.0.0.1"; // MySQL server's IP as seen from SSH machine
        int remotePortDatabase = 3306; // MySQL running on this port

        String userDB = "databaseUser";
        String passwordDB = "databasePassword";

        JSch jsch = new JSch();
        Session session;
        try {
            session = jsch.getSession(userSSH, host, hostPort);
            session.setPassword(passwordSSH);

            // Avoid asking for key confirmation
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            System.out.println("Establishing Connection...");
            session.connect(); // Establish a connection to the SSH server

            int assigned_port = session.setPortForwardingL(portDatabase, remoteHostDatabase, remotePortDatabase);
            System.out.println("localhost:" + assigned_port + " -> " + host + ":" + portDatabase);

            String jdbcUrl = "jdbc:mysql://localhost:" + assigned_port + "/yourDatabaseName";

            Connection conn = DriverManager.getConnection(jdbcUrl, userDB, passwordDB);
            // Use the connection here

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}