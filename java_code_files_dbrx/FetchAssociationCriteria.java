import java.util.List;
import java.util.ArrayList;

public class FetchAssociationCriteria {

    Session session = new Session(); // Create an instance of Session

    public void fetchData() {
        Criteria crit = session.createCriteria(MyEntity.class);
        crit.setFetchMode("someAssociation", FetchMode.JOIN)
           .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        List list = crit.list();
    }

    public static void main(String[] args) {
        FetchAssociationCriteria fac = new FetchAssociationCriteria();
        fac.fetchData();
    }
}

// Stub classes

class Session {
    public Criteria createCriteria(Class<?> clazz) {
        return new Criteria();
    }
}

class Criteria {
    public Criteria setFetchMode(String associationPath, FetchMode mode) {
        // Implementation here
        return this;
    }

    public Criteria setResultTransformer(CriteriaSpecification spec) {
        // Implementation here
        return this;
    }

    public List list() {
        return new ArrayList();
    }
}

class FetchMode {
    public static final FetchMode JOIN = new FetchMode();
}

class CriteriaSpecification {
    public static final CriteriaSpecification DISTINCT_ROOT_ENTITY = new CriteriaSpecification();
}

class MyEntity {
    // Class definition
}