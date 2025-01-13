import oracle.sql.*;
import java.sql.*;

public class OracleTextQuery {
    public static void main(String[] args) throws SQLException {
        // Create a connection to the Oracle database
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL", "username", "password");

        // Create a Oracle Text query
        String query = "SELECT * FROM images WHERE CONTAINS(image_metadata, 'keyword', 1) > 0";

        // Execute the query
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet results = pstmt.executeQuery();

        // Process the results
        while (results.next()) {
            // Retrieve the image metadata
            String imageMetadata = results.getString(1);
            // Process the metadata
            System.out.println(imageMetadata); // You may want to add your processing logic here
        }

        // Close the resources
        results.close();
        pstmt.close();
        conn.close();
    }
}