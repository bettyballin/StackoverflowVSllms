/*
 * Decompiled with CFR 0.152.
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StockRetriever {
    private Connection conn;
    private float price;

    public static void main(String[] stringArray) {
        String string = "your_database_url";
        String string2 = "your_username";
        String string3 = "your_password";
        try (Connection connection = DriverManager.getConnection(string, string2, string3);){
            StockRetriever stockRetriever = new StockRetriever(connection);
        }
        catch (SQLException sQLException) {
            System.err.println(sQLException.getMessage());
        }
    }

    public StockRetriever(Connection connection) {
        this.conn = connection;
        this.price = 0.0f;
    }

    public void retrieveStocks() throws SQLException {
        String string = "begin ? := sp_get_stocks(?); end;";
        try (CallableStatement callableStatement = this.conn.prepareCall(string);){
            callableStatement.registerOutParameter(1, 2012);
            callableStatement.setFloat(2, this.price);
            callableStatement.execute();
            try (ResultSet resultSet = (ResultSet)callableStatement.getObject(1);){
                while (resultSet.next()) {
                }
            }
        }
    }
}
