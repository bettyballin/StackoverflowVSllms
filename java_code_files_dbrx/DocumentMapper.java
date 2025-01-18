public class DocumentMapper {
    public void createTable() {
        EntityManagerFactory emf = topLinkConfiguration();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            if (em.find(Document.class, 1L) != null) {
                // Table exists
                System.out.println("Table already created.");
                return;
            } else {
                // Create Document table
                PersistenceUnitConfig unitConfig = JPAConfiguration.getNewConfiguration();
                DataSourceConnectionSpec dbconnection = new DataSourceConnectionSpec();
                dbconnection.setDatasourceLogin(new DatasourcePlatform(unitConfig));
                DatabaseTableCreator dbtc = new DatabaseTableCreator((DatabaseSession) em, true);
                Class[] classList = new Class[1];
                classList[0] = Document.class;
                try {
                    dbtc.createTables(classList, false);
                } catch (ClassNotFoundException e) {
                    throw e;
                }
                tx.commit();
                System.out.println("Table created!");
            }
        } catch (TransactionFailedException | RollbackException ex) {
            if (tx != null && tx.isActive()) {
                try {
                    tx.rollback();
                } catch (IllegalStateException ille) {
                    // Handle rollback exception
                }
            } else {
                // Rethrow the exception if transaction is not active
                throw ex;
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    public static EntityManagerFactory topLinkConfiguration() {
        // ...Toplink Essentials configuration...
        return null; // placeholder return
    }
}

// Placeholder class definitions
class Document {
}

class PersistenceUnitConfig {
}

class JPAConfiguration {
    static PersistenceUnitConfig getNewConfiguration() {
        return new PersistenceUnitConfig();
    }
}

class DataSourceConnectionSpec {
    void setDatasourceLogin(DatasourcePlatform dp) {
    }
}

class DatasourcePlatform {
    DatasourcePlatform(PersistenceUnitConfig config) {
    }
}

class DatabaseTableCreator {
    DatabaseTableCreator(DatabaseSession session, boolean flag) {
    }

    void createTables(Class[] classList, boolean flag) throws ClassNotFoundException {
    }
}

class DatabaseSession {
}

class TransactionFailedException extends Exception {
}

class EntityManagerFactory {
    public EntityManager createEntityManager() {
        return new EntityManager();
    }

    public void close() {
    }
}

class EntityManager {
    public EntityTransaction getTransaction() {
        return new EntityTransaction();
    }

    public Object find(Class<?> entityClass, Object primaryKey) {
        return null;
    }

    public void close() {
    }
}

class EntityTransaction {
    public void begin() {
    }

    public void commit() {
    }

    public void rollback() {
    }

    public boolean isActive() {
        return false;
    }
}

class RollbackException extends Exception {
}