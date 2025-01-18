import org.basex.core.*;
import org.basex.query.*;
import org.basex.query.value.Value;

public class QueryXML {
    public static void main(String[] args) throws Exception {
        Context context = new Context(); // create context
        try {
            String query = "//course[title='Web Design']";
            QueryProcessor proc = new QueryProcessor(query, context);
            Value result = proc.value();
            System.out.println("\n" + result);
        } finally {
            context.close();
        }
    }
}