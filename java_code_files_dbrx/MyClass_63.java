import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleTypes;

public class MyClass {
    public static void main(String[] args) throws SQLException {
        String sqlQuery = "Your SQL statement here";
        Connection conn = DriverManager.getConnection("your-connection-string");
        OracleCallableStatement cstmt = (OracleCallableStatement) conn.prepareCall(sqlQuery);
        OracleResultSet rs = null;
        int rowsCount = 0;
        StringBuffer desc = new StringBuffer();

        // Parse and get Column info without executing the query:
        cstmt.parse();
        int typeCode = OracleTypes.ARRAY;
        ResultSetMetaData rmd = cstmt.getMetaData();
        for (int i = 1; i <= rmd.getColumnCount(); i++) {
            String typeName = rmd.getColumnTypeName(i);
        }
    }
}