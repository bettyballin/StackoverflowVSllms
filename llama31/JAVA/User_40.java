public class User_40_40 {
    private String name;
    private String email;

    // Constructor
    public User_40(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static void main(String[] args) {
        User_40 user = new User_40("John Doe", "john.doe@example.com");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
    }
}