import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementHelper {
    public static void setBlob(PreparedStatement pst, InputStream inputStream) throws SQLException {
        pst.setBlob(1, inputStream);
    }

    public static void main(String[] args) {
    }
}