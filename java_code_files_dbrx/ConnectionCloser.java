import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionCloser {
    Connection conn = null;

    public ConnectionCloser() {
        try {
            // Open and use connection here
        } catch (Exception e){
            // Handle exception if necessary
        } finally {
            try{
                if(conn != null) {
                    conn.close();
                }
            } catch(SQLException se) { /* Ignore this */ }
        }
    }

    public static void main(String[] args) {
        new ConnectionCloser();
    }
}