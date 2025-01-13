import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetHelper {
    public static BigDecimal getBigDecimal(ResultSet rs, int colIndex) throws SQLException {
        long value = rs.getLong(colIndex);
        return BigDecimal.valueOf(value);
    }

    public static void main(String[] args) {
    }
}