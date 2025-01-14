import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class PostDAOImpl {
    private SessionFactory sessionFactory;

    // Example DAO method to fetch latest posts with indexing optimizations
    public List<PostSummary> getLatestPosts(int limit) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PostSummary> query = builder.createQuery(PostSummary.class);
        Root<Post> root = query.from(Post.class);

        // Selecting only necessary columns for initial view (id, title, user, timestamp)
        query.select(builder.construct(PostSummary.class,
                root.get("postId"),
                root.get("title"),
                root.join("user").get("username"),
                root.get("timestamp")));

        // Order by most recent
        query.orderBy(builder.desc(root.get("timestamp")));

        // Create query and set the maximum results
        List<PostSummary> summaries = session.createQuery(query)
                                             .setMaxResults(limit)
                                             .list();

        session.close();
        return summaries;
    }

    public static void main(String[] args) {
        // You can add code here to test the getLatestPosts method
    }
}