/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseWorkReserver {
    private Connection conn;

    public static void main(String[] stringArray) {
        String string = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String string2 = "username";
        String string3 = "password";
        try (Connection connection = DriverManager.getConnection(string, string2, string3);){
            DatabaseWorkReserver databaseWorkReserver = new DatabaseWorkReserver(connection);
            databaseWorkReserver.reserveWork(1, 10, 1);
        }
        catch (SQLException sQLException) {
            System.err.println(sQLException.getMessage());
        }
    }

    public DatabaseWorkReserver(Connection connection) {
        this.conn = connection;
    }

    public void reserveWork(int n, int n2, int n3) throws SQLException {
        try (PreparedStatement preparedStatement = this.conn.prepareStatement("BEGIN reserveWork(?,?,?); END;");){
            preparedStatement.setInt(1, n);
            preparedStatement.setInt(2, n2);
            preparedStatement.setInt(3, n3);
            preparedStatement.setFetchSize(n2);
            preparedStatement.execute();
        }
    }
}
