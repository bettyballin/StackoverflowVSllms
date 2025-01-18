import com.jcraft.jsch.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class SSHTunnelExample {
    public static void main(String[] args) throws Exception {
        String host = "localhost"; // replace with your hostname
        int remotePort = 3306; // replace with the actual MySQL server port
        int localPort = 12345; // a free local system port
        String user = "user";    // replace with username for SSH
        String password = "pass";// replace with your password for SSH
        String dbUser = "dbUser";   // MySQL database user, if different to username for SSH
        String dbPassword = "dbPass";  // MySQL database password
        String databaseName = "databaseName"; // replace with your actual database name
        String url = "jdbc:mysql://localhost:" + localPort + "/" + databaseName + "?create=true";
        // replace with your actual JDBC URL, but leave the :"+localPort... part alone!
        Connection con = null;
        Session session = null;
        try {
            // create ssh session connection channel to MySQL server using port forwarding localport:localhost remote host and port
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            session = jsch.getSession(user, host, 22); // port can be the default
            session.setPassword(password);
            session.setConfig(config);
            session.connect();
            System.out.println("Connected to SSH server");
            int assigned_port = session.setPortForwardingL(localPort, "localhost", remotePort);
            // use MySQL database with JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            url = "jdbc:mysql://localhost:" + assigned_port + "/" + databaseName + "?create=true";
            con = DriverManager.getConnection(url, dbUser, dbPassword); // use your MySQL username and password
            Statement stmt = null;
            try {
                if (con != null)
                    System.out.println("Connected for JDBC as well...");
                stmt = con.createStatement();
                // now use the statement to execute any query or commands like stmt.executeUpdate(sqlInsertQuery)
            } catch (SQLException e) {
                throw new SQLException(e);
            } finally {
                if (stmt != null)
                    stmt.close();
                con.close();
            }
            session.disconnect();
        } catch (Exception ex) {
            System.err.println("Error in chaining data");
            ex.printStackTrace();
        }
    }
}