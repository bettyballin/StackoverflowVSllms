import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

// Assuming this is part of an Entity class
@NamedQuery(
    name = "fooQuery",
    query = "SELECT f FROM Foo f WHERE f.status IN :statuses"
)

public class FooEntity {
    // ...

    public List<Foo> executeQuery(EntityManager entityManager) {
        Query q = entityManager.createNamedQuery("fooQuery");
        q.setParameter("statuses", Arrays.asList("NEW", "OLD"));
        return q.getResultList();
    }
}