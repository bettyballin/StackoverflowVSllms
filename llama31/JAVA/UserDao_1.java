import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class UserDao_1_1 extends HibernateDaoSupport {

    public void saveUser(User user) {
        getHibernateTemplate().saveOrUpdate(user);
    }

    public User lookupUser(String WebUserId) {
        User user = (User) getHibernateTemplate().get("User", WebUserId);
        return user;
    }

    public static void main(String[] args) {
    }
}