import java.sql.ResultSet;
import java.sql.SQLException;
import java.nio.charset.StandardCharsets;

public class ResultSetHelper {
    // Assuming "result" is a ResultSet object that retrieves your query result.
    ResultSet result;
    String utfEncodedData;

    public static void main(String[] args) {
    }

    public ResultSetHelper() throws SQLException {
        utfEncodedData = new String(result.getString("yourField").getBytes(), StandardCharsets.UTF_8);
    }
}