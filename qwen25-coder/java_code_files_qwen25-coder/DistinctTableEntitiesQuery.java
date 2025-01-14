import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DistinctTableEntitiesQuery {
    public static void main(String[] args) {
        EntityManager entityManager = null; // Needs to be initialized with a proper EntityManager instance

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TableEntity> cq = cb.createQuery(TableEntity.class);
        Root<TableEntity> tableRoot = cq.from(TableEntity.class);

        // Applying distinct to the query
        cq.select(tableRoot).distinct(true);

        List<TableEntity> result = entityManager.createQuery(cq).getResultList();
    }
}

class TableEntity {
    // Placeholder for the actual entity class
}