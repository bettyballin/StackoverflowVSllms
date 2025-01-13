import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class MyService_29_29 {

    @PersistenceContext
    private EntityManager entityManager;

    public List<MyEntity> findAll() {
        return entityManager.createQuery("SELECT e FROM MyEntity e", MyEntity.class).getResultList();
    }

    public static void main(String[] args) {
    }
}