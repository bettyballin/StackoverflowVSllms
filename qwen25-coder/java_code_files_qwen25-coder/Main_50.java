import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    String name;
    int age;

    // constructor, getters, and setters

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class Main_50 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 29));
        people.add(new Person("Bob", 35));

        // Filter to get people older than 30
        List<Person> filteredPeople = people.stream()
            .filter(person -> person.getAge() > 30)
            .collect(Collectors.toList());

        System.out.println(filteredPeople);
    }
}