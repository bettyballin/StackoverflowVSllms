class Session {
    public <T> T load(Class<T> clazz, Object id) {
        try {
            return clazz.newInstance(); // For demonstration purposes
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Object entity) {
        // Do nothing
    }

    public void close() {
        // Do nothing
    }
}

class HibernateSessionFactory {
    public static Session getSession() {
        return new Session();
    }

    public static Session getNewSession() {
        return new Session();
    }
}

class MyEntity {
    private String property;

    public void setProperty(String value) {
        this.property = value;
    }

    public String getProperty() {
        return property;
    }
}

public class Main {
    public static void main(String[] args) {
        int id = 1;

        Session session1 = HibernateSessionFactory.getSession(); // Open first session for transaction management and subsequent updates/merges
        MyEntity newEntity = session1.load(MyEntity.class, id);
        newEntity.setProperty("new value");

        // Create a second session to fetch current data from DB
        Session session2 = HibernateSessionFactory.getNewSession(); // Get another hibernate session using your factory method (you need a unique instance here)
        MyEntity oldEntity = session2.load(MyEntity.class, id);
        // CODEBLC OK#1 compare newEntity and oldEntity values as needed
        if (newEntity.getProperty().equals(oldEntity.getProperty())) {
            System.out.println("Properties are equal");
        } else {
            System.out.println("Properties are not equal");
        }
        session2.close(); // Close the second session since it's not linked with transactional operations anymore and to avoid resource leakage/conflicts

        session1.update(newEntity); // Save changes made on newEntity using first opened session (Session 1)
        // Continue your operation as needed here, e.g., Commit/Rollback depending upon your requirements
        session1.close(); // Close the Session once all transactions are processed successfully or rolled back when in a finally block of try-catch construct.
    }
}