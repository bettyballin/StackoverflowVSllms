import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.SqlParseException;
import org.apache.calcite.sql.parser.SqlParser;

public class SqlValidator_2_2 {
    public static void main(String[] args) {
        String sql = "SELECT * FROM mytable";
        try {
            SqlParser parser = SqlParser.create(sql);
            SqlNode node = parser.parseQuery();
            System.out.println("SQL is valid");
        } catch (SqlParseException e) {
            System.out.println("SQL is invalid: " + e.getMessage());
        }
    }
}