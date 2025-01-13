import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;

import yourpackage.Dao;
import yourpackage.MyEntity;

@Repository
public class JpaDao implements Dao {

    @PersistenceContext(unitName = "PersistanceUnit", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    // Use the injected EntityManager in your DAO methods
    public void saveEntity(MyEntity entity) {
        em.persist(entity);
    }

    public MyEntity findEntity(Long id) {
        return em.find(MyEntity.class, id);
    }

    public static void main(String[] args) {
    }
}