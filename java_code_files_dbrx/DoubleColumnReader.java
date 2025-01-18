import java.lang.String;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoubleColumnReader {
    ResultSet rs;

    public DoubleColumnReader() throws SQLException {
        Double d = rs.getObject("column_name") == null ? null : rs.getDouble("column_name");
        if (d != null) {
            // do something with the value
        } else {
            // the value was null, handle accordingly
        }
    }

    public static void main(String[] args) throws SQLException {
        new DoubleColumnReader();
    }
}