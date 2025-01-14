import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBTableRowCountRetriever {
    String countQuery = "SELECT COUNT(*) FROM your_table";
    Statement countStmt;
    ResultSet countRs;
    int rowCount;
    
    public DBTableRowCountRetriever(Connection conn) throws Exception {
        countStmt = conn.createStatement();
        countRs = countStmt.executeQuery(countQuery);
        countRs.next();
        rowCount = countRs.getInt(1);
    }
    
    public static void main(String[] args) {
        // Main method remains empty as in the original code
    }
}