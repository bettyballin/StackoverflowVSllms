import java.lang.String;
import java.util.Date;
import org.jooq.*;
import org.jooq.impl.DSL;

public class MyQueryObject {
    Table<?> table = DSL.table("STOCKMARKET");
    Field<Date> dateField = DSL.field("DATE", Date.class);
    Field<Double> quoteField = DSL.field("QUOTE", Double.class);
    Field<String> corpField = DSL.field("CORP", String.class);
    DSLContext context;

    public Query getQuery() {
        return context.select(dateField, quoteField)
          .from(table)
          .where(corpField.eq("Amazon"))
          .orderBy(dateField.desc())
          .getQuery();
    }

    public static void main(String[] args) {
    }
}