import java.util.*;

public class Main {

    // Mocked namedParameterJdbcTemplate
    static NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate();

    public static void main(String[] args) {
        List<Map<String, Object>> rows = namedParameterJdbcTemplate.queryForList(
            "SELECT key, string_data, numeric_data FROM table", java.util.Collections.emptyMap()
        );
        
        Map<String, Map<String, List<Object>>> aggregatedRows = new HashMap<>(); // Assuming numeric data is not important for processing here
        for (Map<String, Object> row : rows) {
            String key = (String) row.get("key");
            if (!aggregatedRows.containsKey(key)) {
                aggregatedRows.put(key, new HashMap<>()); // create an entry to aggregate all data related to this 'key'
            }
    
            // process rows individually and calculate aggregate as you go
        }
    }

    // Mocked NamedParameterJdbcTemplate
    static class NamedParameterJdbcTemplate {
        public List<Map<String, Object>> queryForList(String sql, Map<String, ?> paramMap) {
            // Mocked implementation
            List<Map<String, Object>> result = new ArrayList<>();
            // Add some mock data if needed
            Map<String, Object> row1 = new HashMap<>();
            row1.put("key", "key1");
            row1.put("string_data", "data1");
            row1.put("numeric_data", 123);
            result.add(row1);
            Map<String, Object> row2 = new HashMap<>();
            row2.put("key", "key2");
            row2.put("string_data", "data2");
            row2.put("numeric_data", 456);
            result.add(row2);
            return result;
        }
    }
}