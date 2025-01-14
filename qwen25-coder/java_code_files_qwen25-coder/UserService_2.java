public class UserService_2 {
    // Example method to simulate fetching and returning a UserDTO from the database
    public UserDTO getUserByUsername(String username) {
        // Simulated data fetch logic here
        return new UserDTO(username, "user@example.com");
    }

    public static void main(String[] args) {
        // Example usage of getUserByUsername
        UserService_2 service = new UserService_2();
        UserDTO user = service.getUserByUsername("john_doe");
        System.out.println("Username: " + user.getUsername());
        System.out.println("Email: " + user.getEmail());
    }
}

class UserDTO {
    private String username;
    private String email;

    public UserDTO(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // Getter methods (optional, but useful for accessing private fields)
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}