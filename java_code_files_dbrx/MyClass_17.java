import java.util.List;
import java.util.Map;
import java.util.Collections;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class MyClass {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public MyClass(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void processData() {
        List<Map<String, Object>> rows = namedParameterJdbcTemplate.queryForList(
            "SELECT key, SUM(numeric_data) FROM table GROUP BY key", Collections.emptyMap()
        );

        for (Map<String, Object> row : rows) {
            // process aggregate data in $row;
            String key = (String) row.get("key");

            handleIndividualRows(key);
        }
    }

    private void handleIndividualRows(String key) {
        List<Map<String, Object>> individualRows = namedParameterJdbcTemplate.queryForList(
            "SELECT string_data FROM table WHERE key=:key", Collections.singletonMap("key", key)
         );

        // process rows one row at a time;
    }

    public static void main(String[] args) {
        // Initialize namedParameterJdbcTemplate properly
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = null; // Replace with actual initialization

        MyClass myClass = new MyClass(namedParameterJdbcTemplate);
        myClass.processData();
    }
}