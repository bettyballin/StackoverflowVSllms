/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccessMultipleSchemas {
    public static void main(String[] stringArray) throws Exception {
        String string = "jdbc:oracle:thin:@//localhost:1521/ORCL";
        String string2 = "your_username";
        String string3 = "your_password";
        Connection connection = DriverManager.getConnection(string, string2, string3);
        connection.setSchema("SCOTT");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEES");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("ename"));
        }
        preparedStatement.close();
        resultSet.close();
        connection.close();
    }
}
