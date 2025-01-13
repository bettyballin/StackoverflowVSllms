import java.util.HashMap;
import java.util.Map;

public class Main_51 {
    public static String getUserName(String user_id) {
        Map<String, String> users = new HashMap<>();
        users.put("1", "User 1");
        users.put("2", "User 2");
        users.put("3", "User 3");

        return users.getOrDefault(user_id, "Unknown User");
    }

    public static void main(String[] args) {
        System.out.println(getUserName("1"));
        System.out.println(getUserName("4"));
    }
}