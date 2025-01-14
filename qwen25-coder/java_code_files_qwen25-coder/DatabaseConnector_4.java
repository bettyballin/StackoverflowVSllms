import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector_4 {
    String connectionString = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=path_to_your_database.mde;";
    Connection conn;

    public DatabaseConnector_4() {
        try {
            conn = DriverManager.getConnection(connectionString, "", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}