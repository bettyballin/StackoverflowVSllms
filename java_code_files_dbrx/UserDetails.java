public class UserDetails {

    public boolean getUserDetails(String username, String[] name) {
        // Implementation here
        // For demonstration purposes, let's assume we found the user
        name[0] = "John Doe";
        return true;
    }

    public static void main(String[] args) {
        UserDetails ud = new UserDetails();
        boolean found = false;
        String[] userName = new String[1];
        found = ud.getUserDetails("username", userName);
        System.out.println("Found: " + found + ", Username: " + userName[0]);
    }
}