import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mockito.Mockito;

// Unit testing with JUnit
public class CalculatorTest {
    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        assertEquals(2, calc.add(1, 1));
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("CalculatorTest");
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}

// Integration testing with mocking
public class UserServiceTest {
    @Test
    public void testGetUser() {
        // Mock dependencies
        UserRepository repo = Mockito.mock(UserRepository.class);
        Mockito.when(repo.getUser(1)).thenReturn(new User(1, "John Doe"));
        
        UserService service = new UserService(repo);
        User user = service.getUser(1);
        assertEquals("John Doe", user.getName());
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("UserServiceTest");
    }
}

class UserRepository {
    public User getUser(int id) {
        return null;
    }
}

class UserService {
    private UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User getUser(int id) {
        return repo.getUser(id);
    }
}

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// System testing with JMeter
public class SystemTest {
    @Test
    public void testSystem() {
        // Simulate real-world scenario
        // ...
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("SystemTest");
    }
}