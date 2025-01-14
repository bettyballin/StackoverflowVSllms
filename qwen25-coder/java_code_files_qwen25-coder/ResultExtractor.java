import java.util.Map;
import java.util.HashMap;

public class ResultExtractor {
    public static void main(String[] args) {
        // Declare and initialize sqlMapClient
        SqlMapClient sqlMapClient = new SqlMapClient();
        
        // Declare someId
        Object someId = new Object();
        
        // Get resultMap
        Map<String, Object> resultMap = sqlMapClient.queryForObject("selectThreeFields", someId);
        
        String field1 = (String) resultMap.get("field1");
        int field2 = (Integer) resultMap.get("field2");
        double field3 = (Double) resultMap.get("field3");
        
        // For demonstration purposes, print the values
        System.out.println("Field1: " + field1);
        System.out.println("Field2: " + field2);
        System.out.println("Field3: " + field3);
    }
}

class SqlMapClient {
    public Map<String, Object> queryForObject(String query, Object id) {
        // Return a sample map for compilation purposes
        Map<String, Object> map = new HashMap<>();
        map.put("field1", "value1");
        map.put("field2", 123);
        map.put("field3", 456.789);
        return map;
    }
}