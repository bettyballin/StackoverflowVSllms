public class Main {
    public static void main(String[] args) {
        EntityManager em = new EntityManager();
        em.getTransaction().begin(); // begin transaction
        // create and save entities here..
        em.getTransaction().commit(); // end transaction
    }
}

class EntityManager {
    public EntityTransaction getTransaction() {
        return new EntityTransaction();
    }
}

class EntityTransaction {
    public void begin() {
        // Begin transaction
        System.out.println("Transaction started.");
    }
    public void commit() {
        // Commit transaction
        System.out.println("Transaction committed.");
    }
}