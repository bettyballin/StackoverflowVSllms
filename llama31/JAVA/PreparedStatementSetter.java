import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementSetter {
    public static void setString(PreparedStatement ps, int oid) throws SQLException {
        ps.setString(1, String.valueOf(oid));
    }

    public static void main(String[] args) {
    }
}