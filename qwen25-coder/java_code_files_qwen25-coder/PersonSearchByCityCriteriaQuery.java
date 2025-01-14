import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class PersonSearchByCityCriteriaQuery {
    EntityManager entityManager = javax.persistence.Persistence.createEntityManagerFactory("my-persistence-unit").createEntityManager();
    String city = "New York";

    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
    Root<Person> root = criteriaQuery.from(Person.class);

    String searchTerm = city.toLowerCase();

    {
        criteriaQuery.where(criteriaBuilder.like(
                criteriaBuilder.lower(root.get("city")), "%" + searchTerm + "%"));

        TypedQuery<Person> query = entityManager.createQuery(criteriaQuery);
        List<Person> results = query.getResultList();
    }

    public static void main(String[] args) {
    }
}