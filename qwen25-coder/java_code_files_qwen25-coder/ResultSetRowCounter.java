import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetRowCounter {

    int rowCount = 0;
    ResultSet resultSet;

    {
        try {
            if (resultSet != null) {
                while (resultSet.next()) {
                    rowCount++;
                }
                // Reset the resultSet to the beginning if needed for further processing
                resultSet.beforeFirst();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}