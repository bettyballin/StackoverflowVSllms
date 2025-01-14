import java.util.List;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
class A {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // Other fields, getters and setters
    
    public static List<A> getAllEntities(EntityManager em) {
        return em.createQuery("SELECT a FROM A a", A.class).getResultList();
    }
}

@Entity
public class B extends A {
    // Additional properties for B, getters and setters

    public static void main(String[] args) {
    }
}