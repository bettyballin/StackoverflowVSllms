import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import java.util.List;

public class DriversLicenceDAO_1_1 {
    public static void main(String[] args) {
        // Create a Hibernate session factory
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        // Create a Hibernate session
        Session session = sessionFactory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        // Your original code
        Criteria criteria = session.createCriteria(DriversLicence.class);
        criteria.createAlias("licenceClasses", "lc");

        DetachedCriteria subquery = DetachedCriteria.forClass(LicenceClass.class)
                .add(Restrictions.in("name", new String[]{"Car", "Motorbike"}))
                .setProjection(Property.forName("driversLicence.id"))
                .addGroupBy("driversLicence.id")
                .add(Restrictions.eq("count(*)", 2));

        criteria.add(Subqueries.propertyIn("id", subquery));

        List<DriversLicence> results = criteria.list();

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session
        session.close();

        // Close the session factory
        sessionFactory.close();
    }
}