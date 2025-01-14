import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

// Entity class
@Entity
public class MyEntity_6 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Getters and Setters for 'id' and 'name'
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// DAO Class
@Stateless
public class MyEntity_6Dao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<MyEntity_6> findAll() {
        return entityManager.createQuery("select e from MyEntity_6 e", MyEntity_6.class).getResultList();
    }

    public void persist(MyEntity_6 entity) {
        entityManager.persist(entity);
    }
}

// JSF Managed Bean for CRUD operations
@Named
@RequestScoped
public class MyEntity_6Bean {

    @Inject
    MyEntity_6Dao myEntityDao;

    private List<MyEntity_6> entities;
    private MyEntity_6 selectedEntity = new MyEntity_6();

    public void loadEntities() {
        if (entities == null) {
            entities = myEntityDao.findAll();
        }
    }

    public void save() {
        myEntityDao.persist(selectedEntity);
        entities.add(selectedEntity);
        selectedEntity = new MyEntity_6(); // clear the form
    }

    // Getters and Setters for 'entities' and 'selectedEntity'
    public List<MyEntity_6> getEntities() {
        return entities;
    }

    public void setEntities(List<MyEntity_6> entities) {
        this.entities = entities;
    }

    public MyEntity_6 getSelectedEntity() {
        return selectedEntity;
    }

    public void setSelectedEntity(MyEntity_6 selectedEntity) {
        this.selectedEntity = selectedEntity;
    }

    public static void main(String[] args) {
    }
}