import java.lang.String;

// Example of manual DTO coding
public class UserDTO {
    private String name;
    private String email;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class Main {
    // Example of using Dozer for mapping
    public static void main(String[] args) {
        Mapper mapper = new DozerBeanMapper();
        User user = new User(); // assuming you have a User class
        UserDTO dto = mapper.map(user, UserDTO.class);
    }
}