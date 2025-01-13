/*
 * Decompiled with CFR 0.152.
 */
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementHelper {
    public static void setBlob(PreparedStatement preparedStatement, InputStream inputStream) throws SQLException {
        preparedStatement.setBlob(1, inputStream);
    }

    public static void main(String[] stringArray) {
    }
}
