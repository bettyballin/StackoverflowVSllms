/*
 * Decompiled with CFR 0.152.
 */
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetHelper {
    public static BigDecimal getBigDecimal(ResultSet resultSet, int n) throws SQLException {
        long l = resultSet.getLong(n);
        return BigDecimal.valueOf(l);
    }

    public static void main(String[] stringArray) {
    }
}
