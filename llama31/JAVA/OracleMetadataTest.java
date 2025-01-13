import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleMetadataTest {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL", "username", "password");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'ARTIST'");
        while (rs.next()) {
            System.out.println("Constraint name: " + rs.getString("CONSTRAINT_NAME"));
            System.out.println("Constraint type: " + rs.getString("CONSTRAINT_TYPE"));
            System.out.println("Table name: " + rs.getString("TABLE_NAME"));
            System.out.println("Column names: ");
            ResultSet colRs = stmt.executeQuery("SELECT * FROM ALL_CONS_COLUMNS WHERE CONSTRAINT_NAME = '" + rs.getString("CONSTRAINT_NAME") + "'");
            while (colRs.next()) {
                System.out.println("  " + colRs.getString("COLUMN_NAME"));
            }
            colRs.close();
        }
        rs.close();
        stmt.close();
        conn.close();
    }
}