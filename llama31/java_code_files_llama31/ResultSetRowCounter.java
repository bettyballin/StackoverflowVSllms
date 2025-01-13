/*
 * Decompiled with CFR 0.152.
 */
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetRowCounter {
    public static int countRows(ResultSet resultSet) throws SQLException {
        int n = 0;
        while (resultSet.next()) {
            ++n;
        }
        return n;
    }

    public static void main(String[] stringArray) {
    }
}
