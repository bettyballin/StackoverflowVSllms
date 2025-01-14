import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class JacksonJsonArrayParser {
    public static void main(String[] args) throws Exception {
        String jsonArrayString = "[{\"name\":\"John\", \"age\":30}, {\"name\":\"Anna\", \"age\":22}]";
        ObjectMapper mapper = new ObjectMapper();

        List<User> users = mapper.readValue(
            jsonArrayString,
            mapper.getTypeFactory().constructCollectionType(List.class, User.class)
        );

        for (User user : users) {
            System.out.println("Name: " + user.getName());
            System.out.println("Age: " + user.getAge());
        }
    }
}

class User {
    private String name;
    private int age;

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}