/*
 * Decompiled with CFR 0.152.
 */
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementSetter {
    public static void setString(PreparedStatement preparedStatement, int n) throws SQLException {
        preparedStatement.setString(1, String.valueOf(n));
    }

    public static void main(String[] stringArray) {
    }
}
