import java.lang.String;
import java.lang.Integer;

public class SqlServerCodeMapper implements CodeMapper {
    private final String sql = "SELECT * FROM code_sequence;";
    // Assumes jdbcTemplate is configured and injected properly.
    private JdbcTemplate jdbcTemplate;

    @Override
    public int generateNextCodeSequence() {
        int currentSeq = (int) this.jdbcTemplate.queryForObject(this.sql, Integer.class);
        // Update the counter and return incremented value.
        updateCounter(++currentSeq);
        return currentSeq;
    }

    private void updateCounter(int newValue) {
        final String updateSql = "UPDATE code_sequence SET seq=?;";
        jdbcTemplate.update(updateSql, new Object[]{newValue});
    }

    public static void main(String[] args) {
    }
}

interface CodeMapper {
    int generateNextCodeSequence();
}

class JdbcTemplate {
    public Object queryForObject(String sql, Class clazz) {
        return null;
    }

    public void update(String sql, Object[] params) {
    }
}