import java.sql.Connection;
import java.sql.DriverManager;
import oracle.jdbc.OracleConnection;
import oracle.sql.BFILE;

public class OracleFileReader {
    // Using Java - For other languages the approach will be similar
    public static void main(String[] args) {
        try {
            String connectionString = "jdbc:oracle:thin:@host:port:sid"; // your Oracle DB connection string
            String username = "your_username"; // your DB username
            String password = "your_password"; // your DB password

            // Initialize your connection here.
            Connection conn = DriverManager.getConnection(connectionString, username, password);
            OracleConnection oraConn = (OracleConnection) conn;

            BFILE bfile = null;
            boolean isReadingFileSuccessful;

            String filePath = "uploads/myFile.pdf"; // this path is always relative to the directory object created above.

            // Assuming oraDirect is an instance of some class; we'll define it.
            OraDirect oraDirect = new OraDirect();

            bfile = oraDirect.createBlobFromString(
                "SELECT fname FROM tableName WHERE ID=123", oraConn); // retrieve your file path from wherever it was stored.

            isReadingFileSuccessful = bfile.openFile(); // open the BFILE data item.

            conn.close(); // release the connection once file opened to optimize IO operations
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class OraDirect {
    // Dummy method to make the code compile; implement your actual logic here.
    public BFILE createBlobFromString(String sql, OracleConnection conn) {
        return null;
    }
}