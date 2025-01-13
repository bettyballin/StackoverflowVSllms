// Query class
public class Query {
    private String queryString;

    public Query(String queryString) {
        this.queryString = queryString;
    }

    public String getQueryString() {
        return queryString;
    }
}

// ResultSet class
public class ResultSet {
    private String result;

    public ResultSet(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}

// Query parser
public class QueryParser {
    public Query parse(String query) {
        // Basic implementation: just store the query string
        return new Query(query);
    }
}

// Query executor
public class QueryExecutor {
    public ResultSet execute(Query query) {
        // Basic implementation: just return a dummy result
        return new ResultSet("Dummy result for query: " + query.getQueryString());
    }

    public static void main(String[] args) {
        QueryParser parser = new QueryParser();
        QueryExecutor executor = new QueryExecutor();

        String query = "SELECT * FROM table";
        Query parsedQuery = parser.parse(query);
        ResultSet result = executor.execute(parsedQuery);

        System.out.println(result.getResult());
    }
}