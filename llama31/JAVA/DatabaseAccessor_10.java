import java.sql.Connection;
import java.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.InitialContext;

public class DatabaseAccessor_10_10 {
    // Lookup DB connection using JNDI
    private DataSource ds;
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public DatabaseAccessor_10() throws Exception {
        ds = (DataSource) new InitialContext().lookup("jdbc/myDB");
        conn = ds.getConnection();
        pstmt = conn.prepareStatement("SELECT * FROM myTable");
        rs = pstmt.executeQuery();
    }

    public static void main(String[] args) {
        try {
            DatabaseAccessor_10 accessor = new DatabaseAccessor_10();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}