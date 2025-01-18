import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        String sql = "MERGE INTO data USING (SELECT :id AS id, :key AS key FROM DUAL) new_data ON (data.id = new_data.id AND data.key = new_data.key) WHEN MATCHED THEN UPDATE SET value = :value WHEN NOT MATCHED THEN INSERT (id, key, value) VALUES (new_data.id, new_data.key, :value);";
        Connection conn = null; // Replace with your actual connection
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "someId"); // for :id and first values() call
        stmt.setString(2, "testKey"); // for :key and second values() call
        stmt.setString(3, "someValue"); // for both the SET and values() calls
    }
}