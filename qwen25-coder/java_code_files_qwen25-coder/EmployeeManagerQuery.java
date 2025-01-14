import java.util.List;
import java.util.ArrayList;

public class EmployeeManagerQuery {

    public static void main(String[] args) {

        String hql = "SELECT e1.name, e2.name, e1Manager.name " +
                     "FROM Employee e1, Employee e2 INNER JOIN e1.manager e1Manager";
        Session session = new Session();
        Query query = session.createQuery(hql);
        List results = query.list();

    }
}

class Session {
    public Query createQuery(String hql) {
        return new Query(hql);
    }
}

class Query {
    private String hql;

    public Query(String hql) {
        this.hql = hql;
    }

    public List list() {
        return new ArrayList();
    }
}