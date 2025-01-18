// File: ExampleClass.java

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class ExampleClass {

    public void exampleQuery() {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();

                // Your Hibernate query logic here...

                transaction.commit();
            } catch (RuntimeException e) {
                if (transaction != null) {
                    transaction.rollback();
                }
            } finally {
                session.close();
            }
        }
    }

    public static void main(String[] args) {
        ExampleClass example = new ExampleClass();
        example.exampleQuery();
    }
}

// File: org/hibernate/SessionFactory.java

package org.hibernate;

public class SessionFactory implements AutoCloseable {
    public Session openSession() {
        return new Session();
    }

    @Override
    public void close() {
        // Close resources if needed
    }
}

// File: org/hibernate/cfg/Configuration.java

package org.hibernate.cfg;

import org.hibernate.SessionFactory;

public class Configuration {
    public Configuration configure() {
        // Load configuration if needed
        return this;
    }

    public SessionFactory buildSessionFactory() {
        return new SessionFactory();
    }
}

// File: org/hibernate/Session.java

package org.hibernate;

public class Session {
    public Transaction beginTransaction() {
        return new Transaction();
    }

    public void close() {
        // Close resources if needed
    }
}

// File: org/hibernate/Transaction.java

package org.hibernate;

public class Transaction {
    public void commit() {
        // Commit logic if needed
    }

    public void rollback() {
        // Rollback logic if needed
    }
}