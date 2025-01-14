import static org.jooq.impl.DSL.*;
import org.jooq.Field;
import org.jooq.OrderField;
import org.jooq.Select;

public class QueryExample {
    public static void main(String[] args) {
        Field<String> date = field(name("DATE"), String.class);
        Field<Double> quote = field(name("QUOTE"), Double.class);

        OrderField<?> orderByDescDate = date.desc();

        Select<?> q = select(date, quote)
                .from(table("STOCKMARKET"))
                .where(field("CORP").eq("?"))
                .orderBy(orderByDescDate);

        // Print the SQL query
        System.out.println(q.getSQL());
    }
}