import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.dao.DataAccessException;

@Service
public class MyService {

    @Autowired
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public int getCountFromDatabase() {
        try {
            return simpleJdbcTemplate.queryForInt("SELECT COUNT(*) FROM my_table", null);
        } catch (DataAccessException e) {
            // Optionally, you can log the exception or perform other operations.
            // However, if you want to simply propagate it, just rethrow
            throw new RuntimeException("Failed to fetch count from database", e);
        }
    }

    public static void main(String[] args) {
    }
}