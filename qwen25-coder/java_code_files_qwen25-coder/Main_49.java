import java.util.*;
import java.util.stream.Collectors;

public class Main_49 {
    public static void main(String[] args) {
        Map<Integer, Person> peopleMap = new HashMap<>();
        peopleMap.put(1, new Person("Alice", 29));
        peopleMap.put(2, new Person("Bob", 35));

        // Filter to get people older than 30
        List<Person> filteredPeople = peopleMap.values().stream()
            .filter(person -> person.getAge() > 30)
            .collect(Collectors.toList());

        System.out.println(filteredPeople);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public String toString(){
        return name + " (" + age + ")";
    }
}