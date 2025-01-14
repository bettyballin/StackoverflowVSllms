import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.Function;

public class LinQExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 25)
        );

        List<String> namesOfAdults = Linq.from(people)
            .where(p -> p.getAge() >= 18)
            .select(Person::getName)
            .toList();

        System.out.println(namesOfAdults); // Output: [Alice, Bob]
    }
}

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

// Hypothetical Linq class for demonstration purposes
class Linq<T> {
    private final Iterable<T> iterable;

    private Linq(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    public static <T> Linq<T> from(Iterable<T> iterable) {
        return new Linq<>(iterable);
    }

    public <R> Linq<R> select(Function<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T item : iterable) {
            result.add(mapper.apply(item));
        }
        return new Linq<>(result);
    }

    public Linq<T> where(Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : iterable) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return new Linq<>(result);
    }

    public List<T> toList() {
        List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }
}