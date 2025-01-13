import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;

public class SqlValidator {
    public static void main(String[] args) {
        String sql = "SELECT * FROM mytable";
        try {
            CCJSqlParserUtil.parse(sql);
            System.out.println("SQL is valid");
        } catch (JSQLParserException e) {
            System.out.println("SQL is invalid: " + e.getMessage());
        }
    }
}