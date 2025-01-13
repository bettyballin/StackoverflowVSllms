/*
 * Decompiled with CFR 0.152.
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RefCursorExample {
    public static void main(String[] stringArray) {
        String string = "jdbc:oracle:thin:@//localhost:1521/ORCL";
        String string2 = "your_username";
        String string3 = "your_password";
        try (Connection connection = DriverManager.getConnection(string, string2, string3);){
            String string4 = "{call your_procedure_name(?) }";
            CallableStatement callableStatement = connection.prepareCall(string4);
            callableStatement.registerOutParameter(1, 2012);
            callableStatement.execute();
            ResultSet resultSet = (ResultSet)callableStatement.getObject(1);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
            resultSet.close();
            callableStatement.close();
        }
        catch (SQLException sQLException) {
            System.err.println("Error: " + sQLException.getMessage());
        }
    }
}
