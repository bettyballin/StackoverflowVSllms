import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.FileReader;

public class SqlScriptRecorder {
  public static void recordSqlStatement(String sql) throws IOException {
    FileWriter writer = new FileWriter("sql_script.sql", true); // append mode
    PrintWriter printer = new PrintWriter(writer);
    printer.println(sql + ";"); // append a semicolon to each statement
    printer.close();
  }

  public static void executeSqlScript(Connection conn, File scriptFile) throws SQLException, IOException {
    Statement stmt = conn.createStatement();
    BufferedReader reader = new BufferedReader(new FileReader(scriptFile));
    String line;
    while ((line = reader.readLine()) != null) {
      stmt.execute(line);
    }
    stmt.close();
    reader.close(); // Close the reader to prevent resource leaks
  }

  public static void main(String[] args) {
  }
}