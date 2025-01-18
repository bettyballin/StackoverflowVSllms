import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public class SimpleJdbcInsertExample {
    // Example SimpleJdbcInsert usage:
    public static void main(String[] args) {
        DataSource dataSource = null; // initialize appropriately
        Object value1 = null;         // initialize appropriately
        Object value2 = null;         // initialize appropriately

        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("table_name");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("column1", value1);
        parameters.put("column2", value2);
        Number key = simpleJdbcInsert.executeAndReturnKeyHolder(new MapSqlParameterSource(parameters)).getKey();
    }
}