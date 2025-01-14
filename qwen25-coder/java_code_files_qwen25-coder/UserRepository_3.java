import java.util.ArrayList;
import java.util.List;

public class UserRepository_3 {
    private EntityManager entityManager;

    public UserRepository_3() {
        this.entityManager = new EntityManager();
    }

    public List<User> findAllActiveUsers() {
        String sql = "SELECT * FROM users WHERE active = true";
        Query query = entityManager.createNativeQuery(sql, User.class);
        return query.getResultList();
    }

    public static void main(String[] args) {
        // For testing purposes
    }

    // Inner class User
    public static class User {
        // For compilation purposes, can be empty
    }

    // Inner class EntityManager
    public static class EntityManager {
        public Query createNativeQuery(String sql, Class<?> resultClass) {
            return new Query();
        }
    }

    // Inner class Query
    public static class Query {
        public List<User> getResultList() {
            return new ArrayList<User>();
        }
    }
}