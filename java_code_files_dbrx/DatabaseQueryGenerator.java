import java.util.Map;
import java.util.Map.Entry;

public class DatabaseQueryGenerator {
    public String generateUpdateStatement(String tableName, Map<String, Object> fieldValueMap) {
        StringBuilder updateQuery = new StringBuilder("UPDATE " + tableName + " SET");

        boolean isFirstFieldPassed = true;
        for (Entry<String, Object> entry : fieldValueMap.entrySet()) {
            if (!isFirstFieldPassed) {
                // For any additional fields besides the first one, add a comma
                updateQuery.append(",");
            } else {
                isFirstFieldPassed = false;
            }

            String fieldName = entry.getKey();
            Object value = entry.getValue() == null ? "NULL" : "\"" + entry.getValue().toString() + "\"";

            if (!fieldValueMap.containsKey("pkColumn")) { // Exclude primary key column from set condition when generating query
                updateQuery.append(" ").append(fieldName).append("=").append(value);
            }
        }

        Object pk_val = fieldValueMap.getOrDefault("pkColumn", null);
        if (pk_val != null) { // Add where clause only when pk value exists in map for update query
            updateQuery.append(" WHERE primaryKey=").append("\"" + pk_val.toString() + "\"");
        }

        return updateQuery.toString();
    }

    public static void main(String[] args) {
    }
}