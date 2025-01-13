import javax.persistence.*;
import java.util.List;

public class MyEntityDao {
    @PersistenceContext
    private EntityManager em;

    public List<MyEntity> getMyEntities(User currentUser) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<MyEntity> query = builder.createQuery(MyEntity.class);
        Root<MyEntity> root = query.from(MyEntity.class);
        query.where(builder.equal(root.get("region"), currentUser.getRegion()));
        return em.createQuery(query).getResultList();
    }

    public static void main(String[] args) {
        // Create an instance of MyEntityDao and call the getMyEntities method
        MyEntityDao dao = new MyEntityDao();
        // Assuming User is a class with a getRegion method
        User user = new User();
        List<MyEntity> results = dao.getMyEntities(user);
        // Do something with the results
    }
}

// Assuming User is a class with a getRegion method
class User {
    private String region;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}

// Assuming MyEntity is a class with a region field
@Entity
class MyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String region;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}