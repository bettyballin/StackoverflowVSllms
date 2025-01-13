import java.lang.String;

public class JdbcRealmAdapter {
    private JdbcRealm jdbcRealm; // Assuming JdbcRealm is a class with getRoles method

    @Override
    public String[] getRoles(String username) {
        return jdbcRealm.getRoles(username);
    }

    public static void main(String[] args) {
        JdbcRealmAdapter adapter = new JdbcRealmAdapter();
        // Initialize jdbcRealm for the adapter instance
        adapter.jdbcRealm = new JdbcRealm(); // Replace with actual initialization code
        String username = "testUser"; // Replace with actual username
        String[] roles = adapter.getRoles(username);
        for (String role : roles) {
            System.out.println(role);
        }
    }
}

// Assuming JdbcRealm is a class with getRoles method
class JdbcRealm {
    public String[] getRoles(String username) {
        // Replace with actual implementation to get roles from JDBC realm
        return new String[]{"role1", "role2"}; // Dummy implementation
    }
}