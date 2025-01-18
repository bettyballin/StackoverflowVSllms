import java.util.List;

public class IPersonRepository {
    public static class Person {
    }

    public interface PersonRepository {
        List<Person> findAll();
        // You would also have insert/update/delete methods here
    }

    public static void main(String[] args) {
    }
}