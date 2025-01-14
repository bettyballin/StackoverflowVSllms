public class GenericRepositoryorBaseRepository {

    public interface UserRepository {
        User findById(Long id);
        void save(User user);
        // other methods...
    }

    public interface PostRepository {
        Post findById(Long id);
        void save(Post post);
        // other methods...
    }
    
    public static void main(String[] args) {
    }

}

// Class definitions for User and Post
class User {
    // User attributes and methods
}

class Post {
    // Post attributes and methods
}