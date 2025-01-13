import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class OracleQueryMetadata {
    public static void main(String[] args) throws Exception {
        // Load Oracle JDBC driver
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // Establish a connection
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL", "username", "password");

        // Create a callable statement
        String sql = "BEGIN DBMS_SQL.PARSE(:stmt, :sql); DBMS_SQL.DESCRIBE_COLUMNS(:stmt, :col_cnt, :desc_tab); END;";
        CallableStatement cs = conn.prepareCall(sql);

        // Set the query
        String query = "SELECT * FROM dual";
        cs.setString("sql", query);

        // Set the statement handle
        cs.setInt("stmt", 1);

        // Set the column count
        cs.setInt("col_cnt", 0);

        // Set the description table
        cs.setArray("desc_tab", new oracle.sql.ARRAY(oracle.sql.ArrayDescriptor.createDescriptor("DBMS_SQL.DESC_TAB", conn)));

        // Execute the procedure
        cs.execute();

        // Get the column count
        int colCount = cs.getInt("col_cnt");

        // Get the description table
        oracle.sql.Datum[] descTab = ((oracle.sql.ARRAY) cs.getObject("desc_tab")).getOracleArray();

        // Print the column metadata
        for (int i = 0; i < colCount; i++) {
            oracle.sql.STRUCT desc = (oracle.sql.STRUCT) descTab[i];
            Object[] attributes = desc.getAttributes();
            System.out.println("Column " + (i + 1));
            System.out.println("Name: " + attributes[0]);
            System.out.println("Type: " + attributes[1]);
            System.out.println("Length: " + attributes[2]);
            System.out.println();
        }

        // Close the statement and connection
        cs.close();
        conn.close();
    }
}