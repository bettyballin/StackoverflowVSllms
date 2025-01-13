import java.util.List;

// User Aggregate
public class User_11 {
    private Long id;
    private String name;
    private List<Post> posts;
    // getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Post> getPosts() {
        return posts;
    }
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}

// Post Aggregate
class Post {
    private Long id;
    private String content;
    private List<Comment> comments;
    // getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public List<Comment> getComments() {
        return comments;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}

// Comment class which was missing
class Comment {
    private Long id;
    private String content;
    // getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}

// UserRepository
interface UserRepository {
    User findById(Long id);
    void save(User user);
    void delete(Long id);
}

// PostRepository
public class PostRepository {
    public Post findById(Long id) {
        // implementation missing
        return null;
    }
    public void save(Post post) {
        // implementation missing
    }
    public void delete(Long id) {
        // implementation missing
    }

    public static void main(String[] args) {
        // implementation missing
    }
}