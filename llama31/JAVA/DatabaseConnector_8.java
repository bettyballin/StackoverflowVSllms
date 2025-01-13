import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public class DatabaseConnector_8_8 {
    public static void main(String[] args) {
        DatabaseConnector_8 dbConnector = new DatabaseConnector_8();
        dbConnector.connectToDatabase();
    }

    public void connectToDatabase() {
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mydb");
            Connection conn = ds.getConnection();
            // Use the connection to interact with the database
            // You should close the connection when you're done with it
            // conn.close();
        } catch (Exception e) {
            // Handle the exception
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}