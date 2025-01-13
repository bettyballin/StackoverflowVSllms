import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

public class UserDao {
    public static void main(String[] args) {
        // Assume you have a Hibernate SessionFactory and a UserDto class
        Session session = // obtain a Hibernate session instance
        String param1 = // assign a value to param1

        Query query = session.createQuery("select u.name, u.contacts from User u where u.xyz=:param1");
        query.setParameter("param1", param1);

        List<UserDto> results = query.setResultTransformer(Transformers.aliasToBean(UserDto.class)).list();

        // Do something with the results
    }
}