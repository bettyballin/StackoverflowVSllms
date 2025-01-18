import java.util.Optional;

public class Person {
    private String name;

    // Constructor etc...
    public Person(String name) {
        this.name = name;
    }

    public Optional<Person> findByName(String name) {
        // Code that fetches person by given name
        Person person = this.name.equals(name) ? this : null;
        return Optional.ofNullable(person);
    }
}