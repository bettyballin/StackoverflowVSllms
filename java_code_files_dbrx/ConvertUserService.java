public class ConvertUserService {

    UserDto convert(User user) {
        return new UserDto(user.getUsername());
    }
    // ... other conversions if needed

    public static void main(String[] args) {
    }
}

class User {
    public String getUsername() { return ""; }
}

class UserDto {
    public UserDto(String username) { }
}