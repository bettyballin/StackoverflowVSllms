import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BinaryExporter {
    public static void main(String[] args) throws Exception {
        Connection connection = // Initialize your database connection here
        PreparedStatement pstmt = connection.prepareStatement("select BINARY from MYTABLE");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Blob blob = rs.getBlob("BINARY");
            try (InputStream in = blob.getBinaryStream();
                 FileOutputStream out = new FileOutputStream(File.createTempFile("something-", ".binary", new File(".")))) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }
        }
    }
}