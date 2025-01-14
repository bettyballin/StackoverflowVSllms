import java.lang.String;

public class BusinessDaoorBusinessQueryManager {

    EntityManager entityManager;

    Query query = entityManager.createQuery("select distinct b from Business b " +
           "left join fetch b.campaigns c " +
           "left join fetch c.promotions where b.id=:id");

    public static void main(String[] args) {
    }
}

class EntityManager {
    public Query createQuery(String sql) {
        return new Query();
    }
}

class Query {
}