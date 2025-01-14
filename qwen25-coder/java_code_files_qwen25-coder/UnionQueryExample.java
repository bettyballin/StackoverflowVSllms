import java.lang.String;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.Result;
import org.jooq.conf.Configuration;

import static com.example.Tables.TABLE1;
import static com.example.Tables.TABLE2;

public class UnionQueryExample {
    public static void main(String[] args) {
        Configuration configuration = null; // Initialize your configuration here

        DSLContext dsl = DSL.using(configuration);

        Result<?> result = dsl.select(TABLE1.FIELD1, TABLE1.FIELD2)
                               .from(TABLE1)
                               .union(dsl.select(TABLE2.FIELD1, TABLE2.FIELD2)
                                         .from(TABLE2))
                               .fetch();

        // Convert or map `result` to your entity
    }
}