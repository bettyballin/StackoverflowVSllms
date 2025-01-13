import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;

public class QueryAnalyzer {
    public static void analyzeQuery(String query) throws JSQLParserException {
        Statement statement = CCJSqlParserUtil.parse(query);
        // Analyze the statement and detect vendor-specific syntax or issues
    }

    public static void main(String[] args) {
        try {
            analyzeQuery("SELECT * FROM table_name");
        } catch (JSQLParserException e) {
            System.out.println("Error parsing query: " + e.getMessage());
        }
    }
}