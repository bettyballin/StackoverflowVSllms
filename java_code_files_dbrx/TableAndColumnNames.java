import java.sql.*;

public class TableAndColumnNames {
  public static void main(String[] args) throws Exception{
    String[] types = {"TABLE"}; // "VIEW", etc. can also be included here for views and others, respectively.
    Connection conn = DriverManager.getConnection("jdbc:oracle:thin://@url:port/database_name","username", "password");
    DatabaseMetaData metadata = conn.getMetaData();

    // Displaying table names & column names in each table
    ResultSet tables = metadata.getTables(null, null, "%", types);
    while (tables.next()) {
      String tableName = tables.getString("TABLE_NAME");
      String tableSchema = tables.getString("TABLE_SCHEM");
      System.out.println("\nTable: " + tableSchema + "." + tableName);

      ResultSet columns = metadata.getColumns(null, null, tableName, "%");
      while (columns.next()) {
        String columnName = columns.getString("COLUMN_NAME");
        int dataType = columns.getInt("DATA_TYPE");
        System.out.println("  Column: " + columnName);
      }
    }
  }
}