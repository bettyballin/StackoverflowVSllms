import java.lang.String;

public class QueryGenerator_1_1 {
    String commonStr = "ID=27, Name='John Brown', ItemID=102";

    // For INSERT statement
    String insertStr = commonStr.replaceAll("=", "','").replaceAll(",", "','");
    String insertQuery = "INSERT INTO TableName VALUES ('" + insertStr + "')";

    // For UPDATE statement
    String updateQuery = "UPDATE TableName SET " + commonStr + " WHERE ID=27";

    public static void main(String[] args) {
        QueryGenerator_1 queryGenerator = new QueryGenerator_1();
        System.out.println("Insert Query: " + queryGenerator.insertQuery);
        System.out.println("Update Query: " + queryGenerator.updateQuery);
    }
}