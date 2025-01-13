public class QueryGenerator_2_2 {
    public static void main(String[] args) {
        QueryGenerator_2 generator = new QueryGenerator_2();
        System.out.println(generator.getQuery());
    }

    private String dbms = "oracle"; // or "mysql"
    private String query;

    public QueryGenerator_2() {
        if (dbms.equals("oracle")) {
            query = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY column_name) AS row_num FROM table_name) AS subquery WHERE row_num <= N";
        } else if (dbms.equals("mysql")) {
            query = "SELECT * FROM table_name ORDER BY column_name LIMIT N";
        }
    }

    public String getQuery() {
        return query;
    }
}