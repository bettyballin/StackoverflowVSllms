import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
class Person {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    public Person() {}

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and setters...
    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName= firstName;
    }

    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName= lastName;
    }
}

public class MainClass {
    public static void savePerson(EntityManagerFactory emf) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();     // Starting a new transaction.
            entityManager.persist(new Person("Steve", "Rogers")); // passing an object to save into database.
            entityManager.getTransaction().commit();  // Committing the transaction
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("your-persistence-unit-name");
        savePerson(emf);
        emf.close();
    }
}