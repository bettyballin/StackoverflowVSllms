import java.lang.String;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertCompanyRecord {
    String sql = "INSERT INTO your_table (company_name) VALUES (?)";
    Connection connection = null;

    public InsertCompanyRecord() throws Exception {
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "J&J Construction");
            pstmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
    }
}