import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Relations
    @OneToMany(mappedBy = "parent")
    private List<Child> children = new ArrayList<>();

    // Constructors

    public Parent() {}

    // Getters and setters

    public Long getId() {
        return id;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public void addChildToListHere(Child child) {
        child.setParent(this);
        children.add(child);
    }
}

@Entity
class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Parent parent;

    // Constructors

    public Child() {}

    // Getters and setters

    public Long getId() {
        return id;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create your Parent and Child instances here...

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager entityManager = emf.createEntityManager();

        // Start transaction
        entityManager.getTransaction().begin();

        // Persist only the parent
        Child child = new Child();
        Parent parent = new Parent();
        parent.addChildToListHere(child);
        entityManager.persist(parent); // Only persisted with no cascade PERSIST exception here since the associated objects aren't attempted to be saved yet.

        // End transaction and clear entity manager causing the parent to become detached.
        entityManager.getTransaction().commit();
        entityManager.clear(); // Clears the persistence context. This means Parent becomes detached

        // Now you start a new session with your child objects:
        entityManager.getTransaction().begin();
        entityManager.persist(child);
        entityManager.flush(); // You can also commit here if necessary.

        entityManager.getTransaction().commit();

        entityManager.close();
        emf.close();
    }
}