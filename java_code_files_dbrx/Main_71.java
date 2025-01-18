import java.util.List;
import java.util.ArrayList;

class Post {
    // Post fields and methods can be added here
}

class User {
    public List<Post> getAllPosts() {
        // Implement database query to get all posts for this user
        return Database.getPostsByUser(this);
    }
}

class Database {
    private static int queryCount = 0;

    public static void resetQueryCount() {
        queryCount = 0;
    }

    public static int getQueryCount() {
        return queryCount;
    }

    public static List<User> getAllUsers() {
        // Simulate a database query to get all users
        queryCount++; // Query count increases by 1
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            users.add(new User());
        }
        return users;
    }

    public static List<Post> getPostsByUser(User user) {
        // Simulate a database query to get posts for a user
        queryCount++; // Query count increases by 1 for each user
        // For simplicity, return an empty list
        return new ArrayList<Post>();
    }
}

public class Main {
    public static void main(String[] args) {
        Database.resetQueryCount(); // Reset query count

        List<User> users = getAllUsers(); // Get all Users (N=10) from the User table - Query count -> 1
        for (User user : users) { // for-loop runs N times
            List<Post> postsOfUser = user.getAllPosts(); // This triggers a database query to get Posts of this particular user
        }

        System.out.println("Total queries executed: " + Database.getQueryCount()); // Should be N+1 (11)
    }

    public static List<User> getAllUsers() {
        // Implement database query to get all users
        // For simplicity, return a list with 10 dummy users
        return Database.getAllUsers();
    }
}