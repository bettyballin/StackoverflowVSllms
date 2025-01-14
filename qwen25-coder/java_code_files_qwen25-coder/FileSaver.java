import java.lang.String;
import java.util.Set;
import java.io.*;
import java.nio.file.*;
import java.sql.*;

public class FileSaver {
    public static void main(String[] args) throws IOException, SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Step 1: Upload the file to your Java web app (e.g., by receiving it as a part in a POST request)
            // For simplicity, assume `uploadedFile` is the File object obtained from upload.
            File uploadedFile = new File("/path/to/uploaded/file");

            // Step 2: Write the file to the filesystem
            String destinationPath = "/mnt/shareddisk/folder/" + uploadedFile.getName();
            Files.copy(uploadedFile.toPath(), Paths.get(destinationPath), StandardCopyOption.REPLACE_EXISTING);

            // Step 3: Update the database with a BFILE reference
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//yourdbhost:1521/yourdatabase", "user", "password");
            String sql = "INSERT INTO your_table (file_description, file_bfile) VALUES (?, BFILENAME(?, ?))";
            stmt = conn.prepareStatement(sql);

            // Set the description of the file
            stmt.setString(1, "Description of the file");

            // Directory alias defined in Oracle database and path relative to that directory
            String oracleDirectoryAlias = "UPLOAD_DIR";  // This should match the directory object in your DB
            stmt.setString(2, oracleDirectoryAlias);

            // Filename within the Oracle directory (relative path)
            stmt.setString(3, uploadedFile.getName());

            stmt.executeUpdate();

            System.out.println("File saved to disk and BFILE reference updated in database.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    }
}