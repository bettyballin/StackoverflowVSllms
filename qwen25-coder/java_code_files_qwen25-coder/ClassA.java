import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@NamedNativeQuery(
    name = "ClassA.findOrderedByClassCName",
    query = """
        SELECT * FROM ClassA ca
            JOIN ClassB cb ON ca.COLUMN_NAME = cb.id
            JOIN ClassC cc ON cb.AD_POINT_ID = cc.id
        WHERE ca.id = :classAId  
        ORDER BY cc.name ASC""", 
    resultSetMapping = "ClassAMapping"
)
@SqlResultSetMapping(
    name = "ClassAMapping",
    entities = {
        @EntityResult(entityClass = ClassA.class)
    }
)
public class ClassA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "COLUMN_NAME")
    private List<ClassB> lotsOfClasses;

    // Default constructor (required by JPA)
    public ClassA() {
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public List<ClassB> getLotsOfClasses() {
        return lotsOfClasses;
    }

    public void setLotsOfClasses(List<ClassB> lotsOfClasses) {
        this.lotsOfClasses = lotsOfClasses;
    }

    @Override
    public String toString() {
        return "ClassA{id=" + id + '}';
    }

    public static void main(String[] args) {
        // Usage of the named query
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("your-persistence-unit");
        EntityManager entityManager = emf.createEntityManager();

        try {
            Long classAId = 1L; // Replace with actual ID

            String jpql = "SELECT c FROM ClassA c WHERE c.id = :classAId";
            List<ClassA> results = entityManager.createQuery(jpql, ClassA.class)
                                                .setParameter("classAId", classAId)
                                                .getResultList();

            // Do something with the results
            for (ClassA classA : results) {
                System.out.println(classA);
            }
        } finally {
            entityManager.close();
            emf.close();
        }
    }
}

// Stub class for ClassB
@Entity
public class ClassB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Assuming AD_POINT_ID refers to ClassC
    @ManyToOne
    @JoinColumn(name = "AD_POINT_ID")
    private ClassC classC;

    // Default constructor
    public ClassB() {
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public ClassC getClassC() {
        return classC;
    }

    public void setClassC(ClassC classC) {
        this.classC = classC;
    }
}

// Stub class for ClassC
@Entity
public class ClassC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Default constructor
    public ClassC() {
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}