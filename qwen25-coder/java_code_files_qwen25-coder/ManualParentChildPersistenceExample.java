import javax.persistence.*;

public class ManualParentChildPersistenceExample {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            // Create and persist parent
            Parent parent = new Parent();
            parent.setId(1); // Assign an ID or let JPA generate one if applicable
            em.persist(parent);

            // Create and persist child manually
            Child child = new Child();
            child.setId(1); // Assign an ID or let JPA generate one if applicable
            child.setParent(parent);
            em.persist(child);

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }

    }

}

@Entity
class Parent {
    @Id
    private int id;

    public void setId(int id) {
        this.id = id;
    }
}

@Entity
class Child {
    @Id
    private int id;

    @ManyToOne
    private Parent parent;

    public void setId(int id) {
        this.id = id;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}