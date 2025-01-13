/*
 * Decompiled with CFR 0.152.
 */
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main_428 {
    public static void main(String[] stringArray) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test");
        String string = "CREATE TABLE inputs (id INT, input_name VARCHAR(255), value DECIMAL(10, 2))";
        PreparedStatement preparedStatement = connection.prepareStatement(string);
        preparedStatement.execute();
        String string2 = "INSERT INTO inputs (id, input_name, value) VALUES (?, ?, ?)";
        preparedStatement = connection.prepareStatement(string2);
        for (int i = 1; i <= 30; ++i) {
            preparedStatement.setInt(1, i);
            preparedStatement.setString(2, "Input " + i);
            preparedStatement.setBigDecimal(3, BigDecimal.valueOf(10.99));
            preparedStatement.executeUpdate();
        }
        Calculator calculator = new Calculator(connection);
        calculator.runCalculations();
        String string3 = "SELECT * FROM results";
        preparedStatement = connection.prepareStatement(string3);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("Result: " + resultSet.getInt("id") + ", " + resultSet.getString("input_name") + ", " + String.valueOf(resultSet.getBigDecimal("result")));
        }
    }
}
