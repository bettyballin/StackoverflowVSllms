import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.Filters;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Entity
@Filters({
    @Filter(name = "kiteLengthFilter", condition = "length >= :minLength")
})
public class Boy_1 {
    @OneToMany(mappedBy = "boy", fetch = FetchType.EAGER)
    private Set<Kite> kites;

    public static void main(String[] args) {
        // Create a Hibernate session factory
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        // Create a session and perform the query
        Session session = sessionFactory.openSession();
        Criteria crit = session.createCriteria(Boy.class);
        crit.add(Restrictions.eq("name", "Huck"));
        crit.addFilter("kiteLengthFilter", new HashMap<String, Object>() {{ put("minLength", 1); }});
        List list = crit.list();

        // Print the result
        System.out.println(list);

        // Close the session and session factory
        session.close();
        sessionFactory.close();
    }
}

class Kite {
    private Boy boy;
    private int length;

    // Getters and setters
    public Boy getBoy() {
        return boy;
    }

    public void setBoy(Boy boy) {
        this.boy = boy;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}