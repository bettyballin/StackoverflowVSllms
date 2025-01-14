import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateBinaryFile {
    public void updateExcelFile(Connection conn, String filePath, int fileId) throws SQLException, IOException {
        String sql = "UPDATE your_table_name SET excel_file_column = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Read the file into a FileInputStream
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);

            // Set the parameters of the prepared statement
            pstmt.setBinaryStream(1, fis, (int) file.length());
            pstmt.setInt(2, fileId);

            // Execute update
            int updatedRows = pstmt.executeUpdate();
            System.out.println("Updated rows: " + updatedRows);
        }
    }

    public static void main(String[] args) {
    }
}