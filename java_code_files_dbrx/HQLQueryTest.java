import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.junit.Test;

public class HQLQueryTest {

    @Test
    public void hqlQueryTest() {
        Session session = null; // Initialize session
        String hql = "FROM YourEntity WHERE someCondition = :param";
        Query query = session.createQuery(hql);
        // You can set your parameters like so...
        Object yourParamValue = null; // Initialize yourParamValue
        query.setParameter("param", yourParamValue);
        List results = query.list();
    }

    public static void main(String[] args) {
    }
}