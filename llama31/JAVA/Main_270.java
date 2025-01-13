import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Main_270_270 {
    public static void main(String[] args) {
        // Create an ArrayList of Person objects
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", 25));
        persons.add(new Person("Alice", 30));
        persons.add(new Person("Bob", 20));

        // Filter the ArrayList using Stream API
        List<Person> filteredPersons = persons.stream()
                .filter(person -> person.getAge() > 25)
                .collect(Collectors.toList());

        // Print the filtered ArrayList
        filteredPersons.forEach(person -> System.out.println(person.getName() + " " + person.getAge()));

        // Create a HashMap of Person objects
        Map<String, Person> personMap = new HashMap<>();
        personMap.put("John", new Person("John", 25));
        personMap.put("Alice", new Person("Alice", 30));
        personMap.put("Bob", new Person("Bob", 20));

        // Filter the HashMap using Stream API
        Map<String, Person> filteredPersonMap = personMap.entrySet().stream()
                .filter(entry -> entry.getValue().getAge() > 25)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        // Print the filtered HashMap
        filteredPersonMap.forEach((key, value) -> System.out.println(key + " " + value.getAge()));
    }
}