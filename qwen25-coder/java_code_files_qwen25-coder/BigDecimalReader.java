import java.lang.String;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BigDecimalReader {
    ResultSet rs = null;
    int i = 1;
    Object value;

    {
        try {
            value = rs.getBigDecimal(i); // or rs.getObject(i) and cast later if needed
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}