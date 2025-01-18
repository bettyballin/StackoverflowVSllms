import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.ByteArrayInputStream;

public class ExampleSQLite {
    public static void main(String[] args) {
        byte[] byteFromModel = { /* your ML model bytes here */ };

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite::resource:ModelDataBase")) {
            PreparedStatement pstmt = conn.prepareStatement("insert into models(model) VALUES (?)");
            ByteArrayInputStream bais = new ByteArrayInputStream(byteFromModel); // byte[] of bytes from your ML Model
            pstmt.setBlob(1, bais);
            int affectedRows = pstmt.executeUpdate();
        } catch (SQLException e) {
            // Handle exception as needed
            e.printStackTrace();
        }
    }
}