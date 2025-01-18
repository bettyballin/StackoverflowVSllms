import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) throws Exception {
        Integer x = null; // Initialize x as needed
        Integer y = 10;   // Initialize y as needed

        StringBuilder query = new StringBuilder("SELECT z ");
        if (x != null){
            query.append("WHERE x > y");
        } else {
            query.append("WHERE x <= y");
        }
        query.append("JOIN a ON b");

        Connection connection = null; // Initialize connection as needed
        PreparedStatement pstmnt = connection.prepareStatement(query.toString());
        // set parameters using setString, setInt etc here
    }
}