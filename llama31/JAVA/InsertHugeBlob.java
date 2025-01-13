import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertHugeBlob {
  public static void main(String[] args) throws SQLException, Exception {
    Connection conn = DriverManager.getConnection("url", "username", "password");
    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO table (bindata) VALUES (?)");

    File file = new File("c:/tmp/hugefile");
    FileInputStream fis = new FileInputStream(file);
    pstmt.setBinaryStream(1, fis, file.length());
    pstmt.executeUpdate();

    fis.close();
    pstmt.close();
    conn.close();
  }
}