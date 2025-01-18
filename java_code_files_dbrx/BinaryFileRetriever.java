import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Blob;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;

public class BinaryFileRetriever {
    public static void main(String[] args) {
        try {
            // Replace these with your actual database credentials and details
            String url = "jdbc:mysql://localhost:3306/your_database"; // change as needed
            String username = "your_username"; // change as needed
            String password = "your_password"; // change as needed
            
            // Establishing a connection
            Connection connection = DriverManager.getConnection(url, username, password);
            
            int id = 1; // Replace with the actual ID of the row you want to retrieve
            String filename = "outputFile.dat"; // Replace with actual filename
            PreparedStatement pstmt = connection.prepareStatement("SELECT binary_column FROM your_table WHERE id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Blob blob = rs.getBlob("binary_column");
                byte[] fileBytes = blob.getBytes(1, (int) blob.length());
                File outputFile = new File("/path/to/output/" + filename); // replace with actual filename and path
                try (OutputStream out = new FileOutputStream(outputFile)) {
                    out.write(fileBytes);
                } catch (IOException e) {
                    System.err.println("Error writing file: " + e.getMessage());
                }
            } else {
                System.out.println("No row found with specified ID.");
            }
            
            // Clean up
            rs.close();
            pstmt.close();
            connection.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}