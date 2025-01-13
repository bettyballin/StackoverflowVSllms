import java.util.Collection;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.FlushMode;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class HibernateObjectFinder {
    public Collection findAll() {
        DetachedCriteria criteria = DetachedCriteria.forClass(Object.class);
        criteria.setFlushMode(FlushMode.COMMIT);
        return (Collection)getHibernateTemplate().findByCriteria(criteria);
    }

    public static void main(String[] args) {
        HibernateObjectFinder finder = new HibernateObjectFinder();
        finder.findAll();
    }
}