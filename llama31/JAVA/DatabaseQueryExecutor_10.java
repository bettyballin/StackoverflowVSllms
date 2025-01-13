import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseQueryExecutor_10_10 {
    public static void main(String[] args) throws Exception {
        // Assuming myTable and conn are defined somewhere in your code
        MyTable myTable = new MyTable();
        Connection conn = DriverManager.getConnection("url", "user", "password");

        String columnName = "column" + myTable.getMycolumn();
        String query = "SELECT " + columnName + " FROM mytable";
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
    }
}

// Assuming MyTable is a class with getMycolumn method
class MyTable {
    public String getMycolumn() {
        return "mycolumn";
    }
}