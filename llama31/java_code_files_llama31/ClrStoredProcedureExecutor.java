/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClrStoredProcedureExecutor {
    String query = "EXEC my_clr_stored_procedure @param1, @param2";

    public static void main(String[] stringArray) {
        String string = "jdbc:sqlserver://localhost:1433;databaseName=myDB";
        String string2 = "myUser";
        String string3 = "myPassword";
        try (Connection connection = DriverManager.getConnection(string, string2, string3);){
            ClrStoredProcedureExecutor clrStoredProcedureExecutor = new ClrStoredProcedureExecutor();
            clrStoredProcedureExecutor.executeStoredProcedure(connection);
        }
        catch (SQLException sQLException) {
            System.err.println("Error executing stored procedure: " + sQLException.getMessage());
        }
    }

    private void executeStoredProcedure(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(this.query);
        preparedStatement.setString(1, "value1");
        preparedStatement.setString(2, "value2");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
    }
}
