/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main_661 {
    private static final String QUICK_SEARCH = "select * from c where NAME like ?";
    private static final String DB_URL = "jdbc:sqlite:example.db";

    public static void main(String[] stringArray) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL);
        String string = "example";
        try (PreparedStatement preparedStatement = connection.prepareStatement(QUICK_SEARCH);){
            preparedStatement.setString(1, "%" + string + "%");
        }
        connection.close();
    }
}
