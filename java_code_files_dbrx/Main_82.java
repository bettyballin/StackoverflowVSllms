public class Main {

    public static void main(String[] args) {

        EntityManager entityManager = null; // placeholder for entity manager

        // Get the audit reader factory from Hibernate EntityManager
        AuditReader auditReader = AuditReaderFactory.get(entityManager);

        // Find a previous version of an entity by its revision number:
        Customer customerHistory = auditReader.find(Customer.class, 123L, 5); // 123 is the id and 5 is the revision number for undoing to

    }

}

// Simulating external classes

class EntityManager {
    // Minimal implementation
}

class AuditReaderFactory {
    public static AuditReader get(EntityManager entityManager) {
        // Return a new AuditReader
        return new AuditReader();
    }
}

class AuditReader {
    public <T> T find(Class<T> cls, Object id, int revision) {
        // Return an instance of cls
        try {
            return cls.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return null;
        }
    }
}

class Customer {
    // Customer class implementation
}