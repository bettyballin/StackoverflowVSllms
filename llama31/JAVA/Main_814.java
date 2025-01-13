import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;

@Entity
class MyEntity {
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

public class Main_814 {
    public static void main(String[] args) {
        // obtain the EntityManager instance
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
        EntityManager em = emf.createEntityManager();

        Long id = 1L; // Replace with the actual ID
        MyEntity entity = em.find(MyEntity.class, id);
        em.detach(entity);

        em.close();
        emf.close();
    }
}