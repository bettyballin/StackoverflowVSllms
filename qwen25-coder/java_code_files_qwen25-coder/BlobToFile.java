import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BlobToFile {

    public static void main(String[] args) {
        Connection connection = null; // Initialize your connection here
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = connection.prepareStatement("SELECT BINARY FROM MYTABLE");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Blob blob = rs.getBlob("BINARY");
                long length = blob.length();
                System.out.println("Read " + length + " bytes");

                // Create a file to write the output
                File file = new File("path/to/output/directory/something.binary");

                try (FileOutputStream out = new FileOutputStream(file)) {
                    byte[] buffer = new byte[4096]; // 4KB buffer for efficiency
                    long totalBytesRead = 0;

                    try (java.io.InputStream blobStream = blob.getBinaryStream()) {
                        int bytesRead;
                        while ((bytesRead = blobStream.read(buffer)) != -1) {
                            out.write(buffer, 0, bytesRead);
                            totalBytesRead += bytesRead;
                        }
                    }

                    if (totalBytesRead != length) {
                        throw new SQLException("Size of written file does not match expected size.");
                    }
                } catch (IOException e) {
                    System.err.println("Error writing blob to file: " + e.getMessage());
                }
            }
        } catch (SQLException | IOException e) {
            System.err.println("An error occurred while processing the Blob: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close(); // Ensure connection is closed
            } catch (SQLException ex) {
                System.err.println("Error closing resources: " + ex.getMessage());
            }
        }
    }
}