import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class QueryHelperorHibernateQueryHelper {

    // Correct usage of named parameters in HQL
    String hql = "FROM Employee e WHERE e.department = :department AND e.salary > :minSalary";

    {
        // Instance initializer block
        Query query = session.createQuery(hql);
        query.setParameter("department", departmentName);
        query.setParameter("minSalary", minSalaryValue);
        List results = query.list();
    }

    private Session session = null;
    private String departmentName = null;
    private double minSalaryValue = 0.0;

    public static void main(String[] args) {
    }
}