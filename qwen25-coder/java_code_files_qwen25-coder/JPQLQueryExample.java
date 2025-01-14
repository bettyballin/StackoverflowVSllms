import java.util.List;
import javax.persistence.EntityManager;

public class JPQLQueryExample {

    // Using JPQL (Java Persistence Query Language)
    String jpql = "SELECT DISTINCT t FROM TableEntity t";

    EntityManager entityManager;

    List<TableEntity> result = entityManager.createQuery(jpql, TableEntity.class).getResultList();

    public static void main(String[] args) {
    }
}

class TableEntity {
    // Class implementation
}