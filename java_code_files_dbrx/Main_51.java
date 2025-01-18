import java.lang.String;
import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.intercept.SQLStringInterceptor;

public class Main_51 {
    public static void main(String[] args) throws InterruptedException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();   // Get your session factory here...

        final StringBuilder sqlBuilder = new StringBuilder();

        SQLStringInterceptor interceptor = new SQLStringInterceptor() {
            @Override
            public String onPrepareStatement(String sql) {
                sqlBuilder.append(sql).append(";\n");    // Collecting the generated SQL statements...
                return super.onPrepareStatement(sql);
            }
        };

        Session session = sessionFactory.withOptions()
                         .interceptor(interceptor)
                         .openSession();   // open a new Hibernate Session with interception turned on

        try {
            Criteria criteria = session.createCriteria(Operator.class);  // Create your criteria here...
            Object someValue = new Object();  // Define someValue object
            Criterion criterion1 = Restrictions.eq("someField", someValue);
            criteria.add(criterion1).list();   // This will execute the query and generate SQL that is
                                               // intercepted by our SQLStringInterceptor,
                                               // appending it to sqlBuilder
        } finally {
            session.close();  // Don't forget to close the Session after using it...
        }

        System.out.println(sqlBuilder);    // Now print out the accumulated SQL statements...
    }
}

// Dummy HibernateUtil class for compilation
class HibernateUtil {
    public static SessionFactory getSessionFactory() {
        // Return a mock SessionFactory for compilation
        return null;
    }
}

// Dummy Operator class for compilation
class Operator {
    // Define fields and methods as needed
}

// Dummy SQLStringInterceptor class in the appropriate package
package org.hibernate.intercept;

import org.hibernate.EmptyInterceptor;

public class SQLStringInterceptor extends EmptyInterceptor {
    @Override
    public String onPrepareStatement(String sql) {
        return super.onPrepareStatement(sql);
    }
}