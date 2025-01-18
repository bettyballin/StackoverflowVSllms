import java.lang.String;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Subqueries;

public class KiteLengthFilterCriteria {
    public static void main(String[] args) {
        Session session = null;
        int minValue = 0;
        int maxValue = 0;
        Criteria crit = session.createCriteria(Boy.class, "b");
        DetachedCriteria kiteCrit = DetachedCriteria.forClass(Kite.class, "k")
                               .add(Restrictions.eqProperty("k.boyId","b.id"))
                               .add(Restrictions.ge("length", minValue))
                               .add(Restrictions.le("length", maxValue))
                               .setProjection(Projections.property("id"));
        crit.add(Subqueries.exists(kiteCrit));
    }
}

class Boy {
}

class Kite {
}