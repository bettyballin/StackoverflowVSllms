import java.util.Set;

public class SqlOrderByBuilder {
    // Suppose columns is a Set<String> containing all possible ordering columns
    // and sortby is String containing which column name you need to do sorting.

    public String buildQuery(Set<String> columns, String sortby) {
        StringBuilder sb = new StringBuilder("ORDER BY ");
        boolean first = true;
        for (String col : columns) {
            if (!first) {
                sb.append(",");
            } else  {
                first = false;
            }
            // This is string concatenation and prone to SQL injection.
            // In any real application you should replace this with suitable method to avoid SQL injections.
            if (col.equals(sortby)) {
                sb.append(col);
            } else  {
                continue;
            }
        }
        // The dynamic part of Order by clause is built and append it as a whole string
        String query = "SELECT * FROM PERSON " + sb.toString();
        return query;
    }

    public static void main(String[] args) {
        // For testing purposes
        SqlOrderByBuilder builder = new SqlOrderByBuilder();
        Set<String> columns = new java.util.HashSet<String>();
        columns.add("name");
        columns.add("age");
        columns.add("address");
        String sortby = "age";
        String query = builder.buildQuery(columns, sortby);
        System.out.println(query);
    }
}