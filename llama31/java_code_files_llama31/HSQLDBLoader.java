/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HSQLDBLoader {
    public static void main(String[] stringArray) throws SQLException {
        String string = "jdbc:hsqldb:mem:testdb";
        Connection connection = DriverManager.getConnection(string, "sa", "");
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE table1 (id INT, name VARCHAR(255))");
        statement.execute("CREATE TABLE table2 (id INT, table1_id INT, name VARCHAR(255))");
        statement.execute("CREATE TABLE table3 (id INT, table2_id INT, name VARCHAR(255))");
        HSQLDBLoader.loadCSV(connection, "table1", new File("table1.csv"));
        HSQLDBLoader.loadCSV(connection, "table2", new File("table2.csv"));
        HSQLDBLoader.loadCSV(connection, "table3", new File("table3.csv"));
        ResultSet resultSet = statement.executeQuery("SELECT * FROM table1 JOIN table2 ON table1.id = table2.table1_id JOIN table3 ON table2.id = table3.table2_id");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

    private static void loadCSV(Connection connection, String string, File file) throws SQLException {
        try (FileReader fileReader = new FileReader(file);){
            String string2 = "LOAD DATA INFILE '" + file.getAbsolutePath() + "' INTO TABLE " + string + " FIELDS TERMINATED BY ','";
            Statement statement = connection.createStatement();
            statement.execute(string2);
        }
        catch (Exception exception) {
            throw new SQLException("Error loading CSV file", exception);
        }
    }
}
