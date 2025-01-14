import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class TimestampFormatter {

    public String getFormattedTimestamp(ResultSet rs, int columnIndex) throws SQLException {
        Timestamp timestamp = rs.getTimestamp(columnIndex);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(timestamp);
    }
}