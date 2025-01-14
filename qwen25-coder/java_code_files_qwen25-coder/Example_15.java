import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.Query;

public class Example_15 {
    public static void main(String[] args) {
        String sql = "CREATE TABLE users (id INT, name VARCHAR(100), email VARCHAR(254));";
        Query query = DSL.query(sql);
        String formattedSql = DSL.using(SQLDialect.STANDARD).renderInlined(query);
        System.out.println(formattedSql);
    }
}