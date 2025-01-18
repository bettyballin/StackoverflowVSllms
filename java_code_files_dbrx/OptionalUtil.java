import java.util.Optional;

public class OptionalUtil {
    public static final String UNKNOWN = "UNKNOWN";

    Optional<Person> person = getPersonByName("John Doe"); // Can return null or Optional with present Person, can't be NullPointerException.
    String name = Optional.ofNullable(person)
                          .flatMap(p -> p.map(Person::getName))
                          .orElse(UNKNOWN);  // Using map to transform data in optional and using "or" methods avoids checking for null and provides a default value instead.

    public static void main(String[] args) {
        OptionalUtil util = new OptionalUtil();
        System.out.println("Name: " + util.name);
    }

    public Optional<Person> getPersonByName(String nameStr) {
        // This method can return null or Optional<Person>
        if ("John Doe".equals(nameStr)) {
            return Optional.of(new Person("John Doe"));
        } else {
            return null; // can return null
        }
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}