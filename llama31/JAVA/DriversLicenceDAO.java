import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

public class DriversLicenceDAO {
    public static void main(String[] args) {
        // Create a session
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        DriversLicenceDAO dao = new DriversLicenceDAO(session);
        dao.getDriversLicences();
    }

    private Session session;

    public DriversLicenceDAO(Session session) {
        this.session = session;
    }

    public List<DriversLicence> getDriversLicences() {
        Criteria criteria = session.createCriteria(DriversLicence.class);
        criteria.createAlias("licenceClasses", "lc");

        DetachedCriteria subquery = DetachedCriteria.forClass(LicenceClass.class)
            .add(Restrictions.eq("name", "Car"))
            .setProjection(Projections.property("id"));

        criteria.add(Subqueries.propertyIn("lc.id", subquery));

        subquery = DetachedCriteria.forClass(LicenceClass.class)
            .add(Restrictions.eq("name", "Motorbike"))
            .setProjection(Projections.property("id"));

        criteria.add(Subqueries.propertyIn("lc.id", subquery));

        List<DriversLicence> results = criteria.list();
        return results;
    }
}