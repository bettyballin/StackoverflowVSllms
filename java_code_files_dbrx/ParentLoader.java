import java.util.List;

public class ParentLoader {
    EntityManager em = new EntityManager();

    Query q = em.createQuery("SELECT p FROM Parent p LEFT JOIN FETCH p.children", Parent.class);
    List<Parent> parentsWithChildren = q.getResultList(); // This will load all parent objects with their child collection populated without updating the DB.

    public static void main(String[] args) {
    }
}

class EntityManager {
    public Query createQuery(String query, Class cls) {
        return new Query();
    }
}

class Query {
    public List<Parent> getResultList() {
        return null; // Return empty list or appropriate result
    }
}

class Parent {
    List<Child> children;
}

class Child {
}