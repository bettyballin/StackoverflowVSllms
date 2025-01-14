import org.jooq.DSLContext;
import org.jooq.Query;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;

public class SqlSyntaxValidator {
    public static void main(String[] args) {
        String sql = "SELECT * FROM table_name";
        
        try {
            DSLContext create = DSL.using(SQLDialect.POSTGRES, new Settings());
            Query parsedQuery = create.parser().parseQuery(sql);
            System.out.println("The SQL is syntactically correct.");
        } catch (Exception e) {
            System.err.println("The SQL has a syntax error: " + e.getMessage());
        }
    }
}