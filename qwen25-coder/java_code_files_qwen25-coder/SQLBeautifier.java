import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;

public class SQLBeautifier {
    public static void main(String[] args) {
        String sql = "CREATE TABLE users (id INT, name VARCHAR(100), email VARCHAR(254));";
        try {
            Statement statement = CCJSqlParserUtil.parse(sql);
            System.out.println(statement.toString());
        } catch (JSQLParserException e) {
            e.printStackTrace();
        }
    }
}