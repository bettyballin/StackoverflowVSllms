import org.jooq.DSL;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.Condition;
import org.jooq.DSLContext;

import java.sql.Connection;

public class JooqQueryGenerator {
    // Example with jOOQ
    public static void main(String[] args) {
        Connection connection = null; // Initialize your database connection here
        Table<?> TABLE_NAME = null; // Initialize your table here
        Condition CONDITION = null; // Initialize your condition here

        DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
        String sqlQuery = context.selectFrom(TABLE_NAME).where(CONDITION).getSQL();
        System.out.println(sqlQuery);
    }
}