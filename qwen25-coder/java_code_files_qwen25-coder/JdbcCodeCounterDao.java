import java.lang.String;
import java.lang.Integer;

interface CodeCounterDao {
    int getLatestCodeNumber();
    void saveNextCodeNumber(int nextCodeNumber);
}

class JdbcTemplate {
    public <T> T queryForObject(String sql, Class<T> requiredType) {
        // Dummy implementation
        return null;
    }

    public int update(String sql, Object... args) {
        // Dummy implementation
        return 0;
    }
}

public class JdbcCodeCounterDao implements CodeCounterDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCodeCounterDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int getLatestCodeNumber() {
        return jdbcTemplate.queryForObject("SELECT code_number FROM code_counter LIMIT 1", Integer.class);
    }

    @Override
    public void saveNextCodeNumber(int nextCodeNumber) {
        jdbcTemplate.update("UPDATE code_counter SET code_number = ?", nextCodeNumber);
    }

    public static void main(String[] args) {
        // Example usage
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        JdbcCodeCounterDao dao = new JdbcCodeCounterDao(jdbcTemplate);
        int latestCodeNumber = dao.getLatestCodeNumber();
        dao.saveNextCodeNumber(latestCodeNumber + 1);
    }
}