import java.lang.String;

public class SqlQueryBuilder {
    // assuming 'BAR' is a string input from the user
    String barInput = "X"; // user input

    // escape special characters to prevent SQL injection
    String escapedBarInput = barInput.replace("'", "''");

    // construct the query with LIKE and wildcards
    String query = "SELECT * FROM FOO WHERE BAR LIKE '%" + escapedBarInput + "%'";

    public static void main(String[] args) {
        SqlQueryBuilder sqlQueryBuilder = new SqlQueryBuilder();
        System.out.println(sqlQueryBuilder.query);
    }
}