import java.util.List;
import java.util.Map;

public class DatabaseQueryRunner_1_1 {
    /**
     * -- ex: looping through List of Map objects --
     * {@code
     * for (int i = 0; i < list.size(); i++) {
     *     Map map = (Map)list.get(i);
     *     System.out.println(map.get("wordID"));
     *     System.out.println(map.get("word"));
     * }
     * }
     * 
     * @param query - select statement
     * @return List of Map objects
     */
    public static List<Map<String, Object>> runQuery(String query) {
        // implementation of runQuery method is missing
        return null;
    }

    public static void main(String[] args) {
    }
}