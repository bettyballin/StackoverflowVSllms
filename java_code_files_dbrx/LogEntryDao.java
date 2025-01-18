import java.util.List;
import java.util.Arrays;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogEntryDao {

    private JdbcTemplate jdbcTemplate;

    public List<LogEntry> getPaginatedLogEntries(int pageSize, int pageNumber) {
        String sql = "SELECT * FROM log_entries ORDER BY entry_id DESC LIMIT ? OFFSET ?";
        return jdbcTemplate.query(sql, new Object[] {pageSize, (pageNumber - 1) * pageSize}, new LogEntryRowMapper());
    }

    public static void main(String[] args) {
    }
}

class JdbcTemplate {
    public List<LogEntry> query(String sql, Object[] args, RowMapper<LogEntry> rowMapper) {
        // For demonstration purposes, return a dummy list
        return Arrays.asList(new LogEntry());
    }
}

class LogEntry {
    // Minimal class definition
}

interface RowMapper<T> {
    T mapRow(ResultSet rs, int rowNum) throws SQLException;
}

class LogEntryRowMapper implements RowMapper<LogEntry> {
    public LogEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new LogEntry();
    }
}