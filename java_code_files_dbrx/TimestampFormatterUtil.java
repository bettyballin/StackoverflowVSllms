import java.lang.String;
import java.sql.*;
import java.text.SimpleDateFormat;

public class TimestampFormatterUtil {
    // Using ResultSetMetaData to check for timestamp type
    public static void someMethod(ResultSet resultSet, int columnIndex) throws SQLException {
        ResultSetMetaData metadata = resultSet.getMetaData();
        if (metadata.getColumnType(columnIndex) == Types.TIMESTAMP) {
            // Use getTimestamp() method and format it as desired
            Timestamp timestamp = resultSet.getTimestamp(columnIndex);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedTimeStamp = sdf.format(timestamp);
        } else {
            // Continue with getString() for other types
            resultSet.getString(columnIndex);
        }
    }

    public static void main(String[] args) {
    }
}