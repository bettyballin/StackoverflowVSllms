import java.lang.String;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseResultSetProcessor {

    ResultSet rs;

    {
        try {
            while (rs.next()) { // loop through each row in the result set
                int value1 = rs.getInt("column_name1"); //get integer from column 1
                String value2 = rs.getString("column_name2");//get string from column 2
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}