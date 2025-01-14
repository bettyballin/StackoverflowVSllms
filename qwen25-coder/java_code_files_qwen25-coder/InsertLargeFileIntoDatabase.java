import java.sql.*;
import java.io.*;

public class InsertLargeFileIntoDatabase {
    String sql = "INSERT INTO table (bindata) VALUES (?)";
    Connection connection = null; // Placeholder

    public InsertLargeFileIntoDatabase() throws SQLException, FileNotFoundException {
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            try (InputStream in = new FileInputStream("c:/tmp/hugefile")) {
                pstmt.setBinaryStream(1, in);
                pstmt.executeUpdate();
            }
        }
    }

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        new InsertLargeFileIntoDatabase();
    }
}