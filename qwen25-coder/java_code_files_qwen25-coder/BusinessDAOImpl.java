import java.util.List;
import java.util.ArrayList;

public class BusinessDAOImpl {
    public static void main(String[] args) {
        // Create a mock entity manager
        EntityManager entityManager = new EntityManager();

        // Create a Business object
        Business b = new Business();

        Query query = entityManager.createQuery("select distinct b from Business b " +
                "left join fetch b.campaigns c " +
                "left join fetch c.promotions where b.id=:id");
        query.setParameter("id", b.getId());
        List<Business> resultList = query.getResultList();
        Business business = null;
        if (!resultList.isEmpty()) {
            business = resultList.get(0);
        }
    }
}

class Business {
    public Long getId() {
        return 1L; // dummy value
    }
}

class EntityManager {
    public Query createQuery(String qlString) {
        return new Query();
    }
}

class Query {
    public void setParameter(String name, Object value) {
        // do nothing
    }

    public List<Business> getResultList() {
        return new ArrayList<Business>();
    }
}