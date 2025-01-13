import java.util.List;

// Define a JavaBean class
public class Person_2 {
    private String name;
    private int age;
    // Getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}

class PersonForm {
    private List<Person> persons;
    // Getters and setters
    public List<Person> getPersons() {
        return persons;
    }
    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}

// In your Servlet's doPost() method
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class Servlet {
    @PostMapping("/submit")
    public void doPost(@RequestParam PersonForm personForm) {
        // Process the personForm object
    }

    public static void main(String[] args) {
    }
}