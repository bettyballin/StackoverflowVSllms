import java.util.List;

// Person class is missing, so I added a simple implementation
class Person {
    private Long id;
    private String name;

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// Repository example
interface PersonRepository {
    List<Person> getAllPeople();
    Person getPersonById(Long id);
    void savePerson(Person person);
}

// DAO example
interface PersonDAO {
    List<Person> getAllPeopleFromDatabase();
    Person getPersonByIdFromDatabase(Long id);
    void savePersonToDatabase(Person person);
}

public class None_38_38 {
    public static void main(String[] args) {
    }
}