import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

// Entity class (Person.java)
@Entity
public class Person {
    @Id
    private Long id;
    private String zipCode;
    private String city;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

// Entity class (City.java)
@Entity
class City {
    @Id
    private String zipCode;
    private String name;

    // getters and setters
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// Business logic layer (PersonService.java)
import org.springframework.stereotype.Service;
import javax.persistence.TypedQuery;

@Service
public class PersonService {
    @PersistenceContext
    private EntityManager entityManager;

    public void setAddressInfo(Person person, String zipCode) {
        // lookup city from zip code table
        TypedQuery<City> query = entityManager.createQuery("SELECT c FROM City c WHERE c.zipCode = :zipCode", City.class);
        query.setParameter("zipCode", zipCode);
        City city = query.getSingleResult();

        person.setCity(city.getName());
        person.setZipCode(zipCode);
    }
}

// Controller layer (PersonController.java)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    public void setAddressInfo(String zipCode) {
        Person person = new Person();
        personService.setAddressInfo(person, zipCode);
        // save person to database
    }

    public static void main(String[] args) {
        // Create application context
        // This is not possible without Spring framework
        // For simplicity, assume we have a context
        // PersonController controller = new PersonController();
        // controller.setAddressInfo("12345");
    }
}