import java.lang.String;

public class UserMapper {
    public String getUserName(String user_id) {
        if (user_id.equals("1"))
            return "User 1";
        else if (user_id.equals("2"))
            return "User 2";
        else if (user_id.equals("3"))
            return "User 3";
        else
            return "Unknown User";
    }

    public static void main(String[] args) {
        UserMapper mapper = new UserMapper();
        System.out.println(mapper.getUserName("1"));  // prints: User 1
        System.out.println(mapper.getUserName("2"));  // prints: User 2
        System.out.println(mapper.getUserName("3"));  // prints: User 3
        System.out.println(mapper.getUserName("4"));  // prints: Unknown User
    }
}