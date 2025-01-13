import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// Example using Spring's JdbcTemplate
@Repository
public class CustomQueryRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<MyEntity> executeCustomQuery(String sql) {
        return jdbcTemplate.queryForList(sql);
    }

    public static void main(String[] args) {
    }
}