import java.lang.String;

public class OffsetPagingQueryGenerator {
    public static void main(String[] args) {

        // Assume sortOrder is a variable that holds the column you want to sort by, e.g., "age_ID"
        String sortOrder = "age_ID";
        int offset = 0;

        String sql = String.format("select * from Customer_Table ORDER BY %s LIMIT 100 OFFSET %s;", sortOrder, offset);

        // For the next set of results
        offset += 100; // or however many records were fetched in the previous query

        sql = String.format("select * from Customer_Table ORDER BY %s LIMIT 100 OFFSET %s;", sortOrder, offset);

    }
}