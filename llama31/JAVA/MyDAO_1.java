import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyDAO_1_1 {
    @Autowired
    private SessionFactory sessionFactory;

    public List<MyObject> getObjects() {
        // Retrieve data from the database
        Session session = sessionFactory.getCurrentSession();
        Query<MyObject> query = session.createQuery("FROM MyObject", MyObject.class);
        return query.list();
    }

    public static void main(String[] args) {
    }
}