public class ConcurrentUpdateHandler {

    public static void main(String[] args) {
        EntityManager em = new EntityManager();
        SomeTable someTable = em.find(SomeTable.class, 1L);
        someTable.setName("new-name"); // or whatever you want to change
        try {
            em.merge(someTable);
        } catch (OptimisticLockException ex) {
            throw new ConcurrentUpdateException(); // handle it however makes sense in your application context
        }
    }
}

class EntityManager {
    public <T> T find(Class<T> entityClass, Long id) {
        // Simulate finding an entity
        try {
            return entityClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return null;
        }
    }

    public void merge(Object entity) throws OptimisticLockException {
        // Simulate merging an entity
        // For testing purposes, you can throw an exception or leave this empty
    }
}

class SomeTable {
    public void setName(String name) {
        // Set the name
    }
}

class OptimisticLockException extends Exception {
}

class ConcurrentUpdateException extends RuntimeException {
}