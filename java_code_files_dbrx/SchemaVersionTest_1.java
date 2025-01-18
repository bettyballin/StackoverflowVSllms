import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SchemaVersionTest_1 {

    @Test
    public void testDatabase(JdbcTemplate jdbc) {
        int count = jdbc.queryForObject("select count(*) from SCHEMA_VERSION", Integer.class);
        assertEquals(1, count);
    }

    public static void main(String[] args) {
    }
}