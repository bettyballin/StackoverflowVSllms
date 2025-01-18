import java.lang.String;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.util.LowerCaseTransformer;
import java.io.StringReader;

public class SqlFormatter {
  public static void main(String[] args) {
    CCJSqlParserManager parser = new CCJSqlParserManager();

    try {
      String sql = "SELECT * FROM table_name";
      Statement statement = parser.parse(new StringReader(sql));
      String lowerCaseSql = LowerCaseTransformer.lowerCase(statement);
      System.out.println(lowerCaseSql);
    } catch (JSQLParserException e) {
      e.printStackTrace();
    }
  }
}