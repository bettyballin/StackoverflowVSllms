import java.lang.String;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.util.TablesNamesFinder;
import net.sf.jsqlparser.util.SqlFormatter;

public class SqlFormatterExample {
    public static void main(String[] args) throws JSQLParserException {
        String sql = "SELECT * FROM table1 WHERE column1 = 'value1' AND column2 = 'value2';";
        SqlFormatter formatter = new SqlFormatter();
        String formattedSql = formatter.format(sql);
        System.out.println(formattedSql);
    }
}