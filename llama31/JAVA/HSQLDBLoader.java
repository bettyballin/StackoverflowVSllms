import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HSQLDBLoader {
    public static void main(String[] args) throws SQLException {
        // Create a fresh database
        String dbURL = "jdbc:hsqldb:mem:testdb";
        Connection conn = DriverManager.getConnection(dbURL, "sa", "");
        Statement stmt = conn.createStatement();

        // Create tables
        stmt.execute("CREATE TABLE table1 (id INT, name VARCHAR(255))");
        stmt.execute("CREATE TABLE table2 (id INT, table1_id INT, name VARCHAR(255))");
        stmt.execute("CREATE TABLE table3 (id INT, table2_id INT, name VARCHAR(255))");

        // Load CSV data into tables
        loadCSV(conn, "table1", new File("table1.csv"));
        loadCSV(conn, "table2", new File("table2.csv"));
        loadCSV(conn, "table3", new File("table3.csv"));

        // Run some SQL
        ResultSet rs = stmt.executeQuery("SELECT * FROM table1 JOIN table2 ON table1.id = table2.table1_id JOIN table3 ON table2.id = table3.table2_id");
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }

        // Clean up
        rs.close();
        stmt.close();
        conn.close();
    }

    private static void loadCSV(Connection conn, String tableName, File csvFile) throws SQLException {
        try (FileReader reader = new FileReader(csvFile)) {
            String sql = "LOAD DATA INFILE '" + csvFile.getAbsolutePath() + "' INTO TABLE " + tableName + " FIELDS TERMINATED BY ','";
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (Exception e) {
            throw new SQLException("Error loading CSV file", e);
        }
    }
}