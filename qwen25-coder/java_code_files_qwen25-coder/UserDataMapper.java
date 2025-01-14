import java.lang.String;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.HashMap;

// DAO Interface Example
public interface UserDao {
    void save(User user);
    User findById(int id);
    void update(User user);
    void delete(User user);
}

// User class
public class User {
    private int id;
    private String name;

    public User(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}

// ContentValues class (since ContentValues is not in standard Java)
public class ContentValues {
    private Map<String, Object> values = new HashMap<>();

    public void put(String key, String value){
        values.put(key, value);
    }

    public void put(String key, Integer value){
        values.put(key, value);
    }

    // Other put methods as needed
    // And any other necessary methods
}

// Data Mapper Example (simplified)
public class UserDataMapper {
    public User mapToObject(ResultSet resultSet) throws SQLException {
        return new User(resultSet.getInt("id"), resultSet.getString("name"));
    }

    public ContentValues mapToValues(User user) {
        ContentValues values = new ContentValues();
        values.put("id", user.getId());
        values.put("name", user.getName());
        // set other fields
        return values;
    }

    public static void main(String[] args) {
    }
}