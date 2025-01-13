import java.lang.String;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;

public class QueryValidator {
    public static void main(String[] args) {
        String query = "SELECT * FROM x;";
        try {
            CCJSqlParserUtil.parse(query);
            System.out.println("Query is syntactically correct");
        } catch (JSQLParserException e) {
            System.out.println("Query is not syntactically correct:", e);
        }
    }
}