import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main_645 {
    public static void main(String[] args) throws SQLException, IOException {
        // Load the MySQL JDBC driver
        String dbUrl = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        OutputStream os = null;
        InputStream is = null;
        
        try {
            // Step 1: Establish a connection to the database
            conn = DriverManager.getConnection(dbUrl, username, password);
            
            // Step 2: Create a statement object
            stmt = conn.createStatement();
            
            // Step 3: Execute a query to get the ResultSet
            // Replace "your_table" and "field" with your actual table name and field
            rs = stmt.executeQuery("SELECT field FROM your_table WHERE your_condition");
            
            if (rs.next()) {
                java.sql.Blob myfile = rs.getBlob("field");
                is = myfile.getBinaryStream();
                os = new FileOutputStream("output_file");
                
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = is.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            } else {
                System.out.println("No record found.");
            }
        } finally {
            if (is != null) {
                is.close();
            }
            if (os != null) {
                os.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}