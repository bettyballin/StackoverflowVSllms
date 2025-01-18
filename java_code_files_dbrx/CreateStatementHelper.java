import java.lang.String;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class CreateStatementHelper {
    Connection conn;
    Statement stmt = conn.createStatement();

    public static void main(String[] args) {
    }
}