import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.servlet.http.HttpServletRequest;

public class VulnerableUserQuery {
    // HQL injection vulnerability
    public VulnerableUserQuery(HttpServletRequest request, Session session) {
        Query query = session.createQuery("FROM User u WHERE u.name = '" + request.getParameter("name") + "'");
    }

    public static void main(String[] args) {
        // You would need a Hibernate setup and a HttpServletRequest for this to work
        // SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        // Session session = sessionFactory.getCurrentSession();
        // HttpServletRequest request; // Obtain from a Servlet or similar
        // new VulnerableUserQuery(request, session);
    }
}