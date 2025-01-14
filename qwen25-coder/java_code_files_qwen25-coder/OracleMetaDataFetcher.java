import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleMetaDataFetcher {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "yourUsername";
        String password = "yourPassword";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM USER_CONS_COLUMNS WHERE TABLE_NAME='ARTIST'")) {

            while (rs.next()) {
                System.out.println(
                    "CONSTRAINT_NAME: " + rs.getString("CONSTRAINT_NAME") +
                    ", COLUMN_NAME: " + rs.getString("COLUMN_NAME") +
                    ", POSITION: " + rs.getInt("POSITION")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}