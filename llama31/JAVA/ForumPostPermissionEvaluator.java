import java.lang.String;

// Assuming PermissionEvaluator and Authentication are part of the Spring Security framework
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

// Assuming ForumPost is a custom class, its definition is not provided here
class ForumPost {
    private Author author;

    public Author getAuthor() {
        return author;
    }
}

// Assuming Author is a custom class, its definition is not provided here
class Author {
    private String username;

    public String getUsername() {
        return username;
    }
}

public class ForumPostPermissionEvaluator implements PermissionEvaluator {
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        ForumPost post = (ForumPost) targetDomainObject;
        String username = authentication.getName();
        return post.getAuthor().getUsername().equals(username);
    }

    public static void main(String[] args) {
    }
}