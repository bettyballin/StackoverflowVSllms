import javax.naming.*;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class SimpleDatabaseAccess {
    public static void main(String[] args) {
        try {
            // Obtain a JNDI Context
            Context initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");

            // Look up the data source
            DataSource ds = (DataSource)envContext.lookup("jdbc/MyDataSource");
            
            // Establish connection to the database
            try (Connection conn = ds.getConnection()){
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM my_table");
                
                while (rs.next()) {
                    System.out.println(rs.getString("column_name"));
                }
            }

        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }
}