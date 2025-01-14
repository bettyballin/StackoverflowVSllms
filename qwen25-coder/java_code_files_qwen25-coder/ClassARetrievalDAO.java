import java.util.List;
import javax.persistence.EntityManager;

public class ClassARetrievalDAO {

    String jpql = "SELECT a FROM ClassA a JOIN FETCH a.lotsOfClasses b JOIN b.classC c ORDER BY c.name";

    EntityManager entityManager = null;

    List<ClassA> results = entityManager.createQuery(jpql, ClassA.class)
                                        .getResultList();

    public static void main(String[] args) {
    }
}

class ClassA {
    // Class definition or placeholder
}