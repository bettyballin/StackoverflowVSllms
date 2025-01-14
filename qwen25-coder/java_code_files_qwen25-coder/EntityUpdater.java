public class EntityUpdater {

    Session session;

    public EntityUpdater() {
        // Initialize session
        session = HibernateSessionFactory.getSession();
    }

    public void updateEntity() {
        int id = 1; // Assuming some id
        try {
            // Retrieve the original state of the entity
            MyEntity oldEntity = session.get(MyEntity.class, id);
            
            // Detach the oldEntity from the session to modify a new instance without affecting it
            session.evict(oldEntity);

            // Make changes to the entity in memory
            MyEntity newEntity = session.get(MyEntity.class, id);
            newEntity.setProperty("new value");

            // Compare old and new entities
            if (!oldEntity.getProperty().equals(newEntity.getProperty())) {
                System.out.println("Property changed from " + oldEntity.getProperty() + " to " + newEntity.getProperty());
            }

            // Update the entity in the database with the changes
            session.update(newEntity);
            session.beginTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void main(String[] args) {
        EntityUpdater updater = new EntityUpdater();
        updater.updateEntity();
    }
}

// Minimal class definitions to make the code compile

class Session {
    public <T> T get(Class<T> clazz, int id) {
        // Fake implementation
        return null;
    }
    public void evict(Object obj) {
    }
    public void update(Object obj) {
    }
    public Transaction getTransaction() {
        return new Transaction();
    }
    public Transaction beginTransaction() {
        return new Transaction();
    }
    public void close() {
    }
}

class Transaction {
    public void commit() {
    }
    public void rollback() {
    }
}

class HibernateSessionFactory {
    public static Session getSession() {
        return new Session();
    }
}

class MyEntity {
    public void setProperty(String value) {
    }
    public String getProperty() {
        return "";
    }
}