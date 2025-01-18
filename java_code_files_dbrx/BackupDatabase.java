import java.io.*;
import java.sql.*;

public class BackupDatabase {

    public static void main(String[] args) {
        try {
            String databaseName = "your_database";
            String fileName = "/path/to/backupfile.sql";
            String userName = "username";
            String password = "password";
            String url = "jdbc:mysql://localhost/" + databaseName;
            PreparedStatement pstmt = null;
            DatabaseMetaData dbmd;
            ResultSet rs = null;
            Connection conn = DriverManager.getConnection(url, userName, password);
            dbmd = conn.getMetaData();
            rs = dbmd.getTables(null, "%", "%", new String[]{"TABLE"});
            
            while (rs.next()) {
                FileWriter fw = new FileWriter(fileName);
                FileWriter fwappend = new FileWriter(fileName, true); // create file writer for append mode.
                BufferedWriter bw = new BufferedWriter(fw);
                BufferedWriter bwappend = new BufferedWriter(fwappend);
                
                // SQL statement to generate DDL statements and data insertion into textfile.
                String query = "select * from " + rs.getObject("TABLE_NAME").toString() + ";";
                Statement stmt = conn.createStatement();
                ResultSet rs2 = stmt.executeQuery(query);
                ResultSetMetaData rsmd = rs2.getMetaData(); // Get the metadata for result set column names and other information.
                
                bwappend.write("\n\n"); // write a blank line to ensure correct format even if there are no rows in any table.
                bwappend.write("DROP TABLE IF EXISTS " + rsmd.getTableName(1) + ";"); // Drop old table from destination database.
                
                int columnCount = rsmd.getColumnCount();
                bwappend.write("\nCREATE TABLE " + rsmd.getTableName(1) + " ("); // Start creating table structure
                
                for (int i = 1; i <= columnCount; i++) {
                    String colName = rsmd.getColumnName(i);
                    String sql_col = rsmd.getColumnTypeName(i);
                    int precision = rsmd.getPrecision(i);
                    int scale = rsmd.getScale(i);
                    
                    if (precision != 0) {
                        sql_col += "(" + precision;
                        if (scale != 0) {
                            sql_col += "," + scale;
                        }
                        sql_col += ")";
                    }
                    
                    bwappend.write("\n  " + colName + " " + sql_col);
                    if (i < columnCount) {
                        bwappend.write(",");
                    }
                }
                
                bwappend.write("\n);\n\n"); // End of table creation
                
                // Close writers
                bwappend.close();
                bw.close();
                fwappend.close();
                fw.close();
            } // end table loop
            
        } catch (SQLException | IOException e) {
            // Handle exception if something went wrong during execution of SQL statements
            e.printStackTrace();
        }
    }
}