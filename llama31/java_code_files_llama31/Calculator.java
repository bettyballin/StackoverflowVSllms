/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class Calculator {
    private Connection conn;

    public Calculator(Connection connection) {
        this.conn = connection;
    }

    public void runCalculations() throws SQLException {
        String string = "CREATE TABLE results (id INT, input_name VARCHAR(255), result DECIMAL(10, 2))";
        PreparedStatement preparedStatement = this.conn.prepareStatement(string);
        preparedStatement.execute();
        String string2 = "INSERT INTO results (id, input_name, result) SELECT id, input_name, value FROM inputs";
        preparedStatement = this.conn.prepareStatement(string2);
        preparedStatement.executeUpdate();
    }
}
